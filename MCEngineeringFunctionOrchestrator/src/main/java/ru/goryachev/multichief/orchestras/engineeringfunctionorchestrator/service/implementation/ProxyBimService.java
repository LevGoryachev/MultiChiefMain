package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.ProxyService;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.ConstructionMicroServiceConnector;

import java.util.List;
import java.util.Map;

@Service
public class ProxyBimService implements ProxyService {

    private ConstructionMicroServiceConnector constructionConnector;

    @Autowired
    public ProxyBimService(ConstructionMicroServiceConnector constructionConnector) {
        this.constructionConnector = constructionConnector;
    }

    public List<Object> getAllBims (){
        return constructionConnector.getAllBims();
    }

    public Object getBim (Long bimId) {
        return constructionConnector.getBim(bimId);
    }

    public Object saveBim (Map<String, Object> requestDto){
        return constructionConnector.saveBim(requestDto);
    }

    public void deleteProject (){

    }

}
