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

    //@Value("${urlscheme.multichief.construction}")
    private String domainUrl = "http://localhost:8080/Gradle___ru_goryachev___MultiChiefConstruction_war/"; // microserviceUrl from yml
    //@Value("${urlscheme.multichief.construction.apiversion}")
    private String apiVersion = "api/v1/";//yml
    //@Value("${urlscheme.multichief.construction.bim}")
    private String subDomainBim = "bims/"; //yml

    private String baseUrl = domainUrl + apiVersion;

    //private RestTemplate restTemplate;
   /* @Autowired
    public ConstructionMicroServiceConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    public List<Object> getAllBims() {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomainBim);
        ResponseEntity<List<Object>> response = this.exchange(urlBuilder.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>(){});
        return response.getBody();
    }

    public Object getBim(Long id) {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomainBim)
                .append(id);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.GET, null, Object.class);
        return response.getBody();
    }

    public Object saveBim(Map<String, Object> requestDto) {
        StringBuffer urlBuilder = new StringBuffer(baseUrl)
                .append(subDomainBim);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpRequest = new HttpEntity(requestDto, headers);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.POST, httpRequest, Object.class);
        return response.getBody();
    }

/*
    public Object deleteConstruction(Long id) {
        urlBuilder
                .append(subDomainBim)
                .append(id);
        String constructionApi = urlBuilder.toString();
        ResponseEntity<Object> response = restTemplate.exchange(constructionApi, HttpMethod.DELETE, null, Object.class);
        return response.getBody();
    }*/
}
