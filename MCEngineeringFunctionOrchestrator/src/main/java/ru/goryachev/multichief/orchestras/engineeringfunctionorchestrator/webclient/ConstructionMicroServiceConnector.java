package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Custom Connector class for MultiChiefConstruction microservice (the domain Construction).
 * Local variable (urlBuilder) is for building the url of target entity/subdomain CRUD.
 * The Fields (domainUrl, apiVersion) are for main segments of url - from properties (application.yml).
 * CRUD methods require parameters for additional segments of url to build the target url.
 * @author Lev Goryachev
 * @version 1-0
 */

@Component
@PropertySource("classpath:application.yml")
public class ConstructionMicroServiceConnector extends AbstractConnector {

    private ConstructionMicroServiceConnector (@Value("${urlscheme.multichief.construction.domain}") String domainUrl,
                                               @Value("${urlscheme.multichief.construction.apiversion}") String apiVersion) {
        this.domainUrl = domainUrl;
        this.apiVersion = apiVersion;
    }
}
