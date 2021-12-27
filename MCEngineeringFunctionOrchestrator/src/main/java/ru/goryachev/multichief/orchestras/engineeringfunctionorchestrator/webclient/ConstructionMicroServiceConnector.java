package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
//@PropertySource("classpath:microservices.properties")
public class ConstructionMicroServiceConnector extends RestTemplate {

    //@Value("${urlscheme.multichief.construction.domain}")
    private String domainUrl = "http://localhost:8080/Gradle___ru_goryachev___MultiChiefConstruction_war/"; // microserviceUrl from yml
    //@Value("${urlscheme.multichief.construction.apiversion}")
    private String apiVersion = "api/v1/";//yml

    private String baseUrl = domainUrl + apiVersion;

    //private RestTemplate restTemplate;
   /* @Autowired
    public ConstructionMicroServiceConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    //BIM domain:
    public List<Object> getAll(String subDomain) {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomain);
        ResponseEntity<List<Object>> response = this.exchange(urlBuilder.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>(){});
        return response.getBody();
    }

    public Object getOne(String subDomain, Long id) {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomain)
                .append(id);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.GET, null, Object.class);
        return response.getBody();
    }

    public Object save(String subDomain, Map<String, Object> requestDto) {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomain);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpRequest = new HttpEntity(requestDto, headers);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.POST, httpRequest, Object.class);
        return response.getBody();
    }

    public Object delete(String subDomain, Long id) {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomain)
                .append(id);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.DELETE, null, Object.class);
        return response.getBody();
    }
}
