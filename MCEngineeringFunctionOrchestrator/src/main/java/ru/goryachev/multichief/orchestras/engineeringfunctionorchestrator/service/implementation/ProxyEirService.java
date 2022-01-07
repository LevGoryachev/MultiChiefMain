package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.AbstractProxyService;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.ConstructionMicroServiceConnector;

/**
 * The connector provides connection with appropriate microservice (domain).
 * The parameter subDomain defines a segment of url of sub-domain entity.
 * CRUD methods of AbstractProxyService use these parameters
 * @author Lev Goryachev
 * @version 1-0
 */

@Service
@PropertySource("classpath:application.yml")
public class ProxyEirService extends AbstractProxyService {

    @Autowired
    private ProxyEirService (@Value("${urlscheme.multichief.construction.subdomain.eir}") String subDomain, ConstructionMicroServiceConnector constructionConnector) {
        this.subDomain = subDomain;
        this.connector = constructionConnector;
    }
}
