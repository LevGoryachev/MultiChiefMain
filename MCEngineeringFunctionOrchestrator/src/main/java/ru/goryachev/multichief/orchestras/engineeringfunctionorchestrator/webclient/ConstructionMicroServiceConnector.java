package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@PropertySource("classpath:microservices.properties")
public class ConstructionMicroServiceConnector {

    //@Value("${urlscheme.multichief.construction}")
    private String domainUrl = "http://localhost:8080/Gradle___ru_goryachev___MultiChiefConstruction_war/"; // microserviceUrl from yml
    //@Value("${urlscheme.multichief.construction.apiversion}")
    private String apiVersion = "api/v1/";//yml
    //@Value("${urlscheme.multichief.construction.bim}")
    private String subDomainBim = "bims/"; //yml

    private StringBuffer urlBuilder = new StringBuffer(domainUrl+apiVersion);

    private RestTemplate restTemplate;

    @Autowired
    public ConstructionMicroServiceConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getConstructionJson(Long id) {
        urlBuilder
                .append(subDomainBim)
                .append(id);
        //String constructionApi = urlBuilder.toString();
        ResponseEntity<Object> response = restTemplate.exchange(urlBuilder.toString(), HttpMethod.GET, null, Object.class);
        return response.getBody();
    }

    public Object createConstructionJson(Object constructionDTO) {
        urlBuilder
                .append(subDomainBim);
        String constructionApi = urlBuilder.toString();
        ResponseEntity<Object> response = restTemplate.exchange(constructionApi, HttpMethod.POST, null, Object.class);
        return response.getBody();
    }

    public Object updateConstructionJson(Object constructionDTO) {
        urlBuilder
                .append(subDomainBim);
        String constructionApi = urlBuilder.toString();
        ResponseEntity<Object> response = restTemplate.exchange(constructionApi, HttpMethod.PUT, null, Object.class);
        return response.getBody();
    }

    public Object deleteConstruction(Long id) {
        urlBuilder
                .append(subDomainBim)
                .append(id);
        String constructionApi = urlBuilder.toString();
        ResponseEntity<Object> response = restTemplate.exchange(constructionApi, HttpMethod.DELETE, null, Object.class);
        return response.getBody();
    }
}
