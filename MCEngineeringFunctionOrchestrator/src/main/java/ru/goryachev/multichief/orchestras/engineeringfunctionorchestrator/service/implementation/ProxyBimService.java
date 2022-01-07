package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProxyBimService implements ProxyService {

    private final Logger log = LoggerFactory.getLogger(ProxyBimService.class);

    @Value("${urlscheme.multichief.construction.subdomain.bim}")
    private String subDomain;

    private ConstructionMicroServiceConnector constructionConnector;

    @Autowired
    public ProxyBimService(ConstructionMicroServiceConnector constructionConnector) {
        this.constructionConnector = constructionConnector;
    }

    public List<Object> getAll (){
        return constructionConnector.getAll(subDomain);
    }

    public Object getOne (Long bimId) {
        log.info("ProxyBimService" + ", " + "getOne(" + bimId + ")");
        return constructionConnector.getOne(subDomain, bimId);
    }

    //Bim requestDto format:
    /*Map<String, Object> newBim = new LinkedHashMap<>();
        newBim.put("id","");
        newBim.put("projectCodeNumber","SE-2");
        newBim.put("projectName","Exp from Proxy Orchestrator");
        newBim.put("lod","300");
        newBim.put("projectTypeId","");
        newBim.put("eirId","");
        newBim.put("link","/httl/ddd/xxx/yyyy");*/

    public Object save (Map<String, Object> requestDto){
        return constructionConnector.save(subDomain, requestDto);
    }

    public Object delete (Long bimId){
        return constructionConnector.delete(subDomain, bimId);
    }
}
