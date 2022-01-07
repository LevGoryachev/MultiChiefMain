package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service;


import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.AbstractConnector;

import java.util.List;
import java.util.Map;

/**
 * Supposed to be extended by custom ProxyService class, then:
 * the variable subDomain should be initialized using properties,
 * the variable connector should be initialized through autowiring
 * @author Lev Goryachev
 * @version 1-0
 */

public abstract class AbstractProxyService implements ProxyService {

    protected String subDomain;
    protected AbstractConnector connector;

    @Override
    public List<Object> getAll (){
        return connector.getAll(subDomain);
    }

    @Override
    public Object getOne (Long bimId) {
        return connector.getOne(subDomain, bimId);
    }

    @Override
    public Object save (Map<String, Object> requestDto){
        return connector.save(subDomain, requestDto);
    }

    @Override
    public Object delete (Long bimId){
        return connector.delete(subDomain, bimId);
    }
}
