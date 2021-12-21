package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@PropertySource("classpath:microservices.properties")
public class StaffMicroServiceConnector {

    //@Value("${urlscheme.multichief.construction}")
    private String domainUrl = "http://localhost:8080/Gradle___ru_goryachev___MultiChiefStaff_war/"; // microserviceUrl from yml
    //@Value("${urlscheme.multichief.construction.apiversion}")
    private String apiVersion = "api/v1/";//yml
    //@Value("${urlscheme.multichief.construction.bim}")
    private String subDomainEmployee = "employees/"; //yml
    private StringBuffer urlBuilder = new StringBuffer(domainUrl+apiVersion);
    private RestTemplate restTemplate;

    @Autowired
    public StaffMicroServiceConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getEmployeeJson(Long id) {
        urlBuilder
                .append(subDomainEmployee)
                .append(id);
        ResponseEntity<Object> response = restTemplate.exchange(urlBuilder.toString(), HttpMethod.GET, null, Object.class);
        return response.getBody();
    }

    //Read methods only

}
