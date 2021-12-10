package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.ResponseEntity;

public class RestTemplateSmpl {

    @Autowired
    RestTemplate restTemplate;

    public String getConstructionJson() {
        String theUrl = "https://xxx.yyyy.com/page";
        ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, String.class);
        return response.getBody();
    }
}
