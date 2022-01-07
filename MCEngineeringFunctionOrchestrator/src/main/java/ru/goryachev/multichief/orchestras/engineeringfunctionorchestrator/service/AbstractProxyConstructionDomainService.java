package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service;


import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.ConstructionMicroServiceConnector;

import java.util.List;
import java.util.Map;

public abstract class AbstractProxyConstructionDomainService implements ProxyService {

    protected String subDomain;
    protected ConstructionMicroServiceConnector constructionConnector;

    @Override
    public List<Object> getAll (){
        return constructionConnector.getAll(subDomain);
    }

    @Override
    public Object getOne (Long bimId) {
        return constructionConnector.getOne(subDomain, bimId);
    }

    @Override
    public Object save (Map<String, Object> requestDto){
        return constructionConnector.save(subDomain, requestDto);
    }

    @Override
    public Object delete (Long bimId){
        return constructionConnector.delete(subDomain, bimId);
    }
}
