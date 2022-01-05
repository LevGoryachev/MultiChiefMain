package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * It supposed to be used one instance of certain custom Connector class for one domain or model or microservice.
 * Local variable (urlBuilder) is for building the url of target entity/subdomain CRUD.
 * The Fields (domainUrl, apiVersion) are for main segments of the target url (domain/microservice url) - they must be initialized once (custom Connector constructor).
 * The parameters of methods (subDomain, id) are for additional segments of the target url.
 * @author Lev Goryachev
 * @version 1-0
 */

public abstract class AbstractConnector extends RestTemplate {

    protected String domainUrl;
    protected String apiVersion;

    public List<Object> getAll(String subDomain) {
        StringBuffer urlBuilder = new StringBuffer()
                .append(domainUrl)
                .append(apiVersion)
                .append(subDomain);
        ResponseEntity<List<Object>> response = this.exchange(urlBuilder.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>(){});
        return response.getBody();
    }

    public Object getOne(String subDomain, Long id) {
        StringBuffer urlBuilder = new StringBuffer()
                .append(domainUrl)
                .append(apiVersion)
                .append(subDomain)
                .append(id);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.GET, null, Object.class);
        return response.getBody();
    }

    public Object save(String subDomain, Map<String, Object> requestDto) {
        StringBuffer urlBuilder = new StringBuffer()
                .append(domainUrl)
                .append(apiVersion)
                .append(subDomain);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpRequest = new HttpEntity(requestDto, headers);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.POST, httpRequest, Object.class);
        return response.getBody();
    }

    public Object delete(String subDomain, Long id) {
        StringBuffer urlBuilder = new StringBuffer()
                .append(domainUrl)
                .append(apiVersion)
                .append(subDomain)
                .append(id);
        ResponseEntity<Object> response = this.exchange(urlBuilder.toString(), HttpMethod.DELETE, null, Object.class);
        return response.getBody();
    }
}
