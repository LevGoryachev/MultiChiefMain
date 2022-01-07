package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.ProxyService;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.ConstructionMicroServiceConnector;

import java.util.List;
import java.util.Map;

@Service
@PropertySource("classpath:application.yml")
public class ProxyProjectTypeService implements ProxyService {

    @Value("${urlscheme.multichief.construction.subdomain.type}")
    private String subDomain;

    private ConstructionMicroServiceConnector constructionConnector;

    @Autowired
    public ProxyProjectTypeService(ConstructionMicroServiceConnector constructionConnector) {
        this.constructionConnector = constructionConnector;
    }

    @Override
    public List<Object> getAll (){
        return constructionConnector.getAll(subDomain);
    }

    @Override
    public Object getOne (Long projectTypeId) {
        return constructionConnector.getOne(subDomain, projectTypeId);
    }

    @Override
    public Object save (Map<String, Object> requestDto){
        return constructionConnector.save(subDomain, requestDto);
    }

    @Override
    public Object delete (Long projectTypeId){
        return constructionConnector.delete(subDomain, projectTypeId);
    }
}
