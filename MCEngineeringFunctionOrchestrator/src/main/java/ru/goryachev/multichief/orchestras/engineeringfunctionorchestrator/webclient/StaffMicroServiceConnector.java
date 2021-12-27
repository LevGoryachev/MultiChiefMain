package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
//@PropertySource("classpath:microservices.properties")
public class StaffMicroServiceConnector extends RestTemplate {

    //@Value("${urlscheme.multichief.construction}")
    private String domainUrl = "http://localhost:8080/Gradle___ru_goryachev___MultiChiefStaff_war/"; // microserviceUrl from yml
    //@Value("${urlscheme.multichief.construction.apiversion}")
    private String apiVersion = "api/v1/";//yml

    private String baseUrl = domainUrl + apiVersion;

    //private RestTemplate restTemplate;
   /* @Autowired
    public StaffMicroServiceConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    public List<Object> getAll(String subDomain) {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomain);
        ResponseEntity <List<Object>> response = this.exchange(urlBuilder.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>(){});
        List<Object> allEmployees = response.getBody();
        return allEmployees;
    }

    public Object getOne(String subDomain, Long id) {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomain)
                .append(id);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.GET, null, Object.class);
        return response.getBody();
    }
    //Read methods only
}
