package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.ProjectApproval;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation.BundleProjectApprovalService;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation.ProxyBimService;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MCEngineeringFunctionOrchestrator API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1-0
 */

@Controller
@RequestMapping("/api/v1-0/projects")
public class ProjectApprovalController {

    private BundleProjectApprovalService bundleProjectApprovalService;

    //todo delete this after
    @Autowired
    private ProxyBimService proxyBimService;

    @Autowired
    public ProjectApprovalController(BundleProjectApprovalService bundleProjectApprovalService) {
        this.bundleProjectApprovalService = bundleProjectApprovalService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ProjectApproval>> getAllProjects (){
        return new ResponseEntity<>(bundleProjectApprovalService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("{projectId}")
    public ResponseEntity<Object> getProject (@PathVariable Long projectId){
        return new ResponseEntity<>(bundleProjectApprovalService.getProject(projectId), HttpStatus.OK);
    }

    @PostMapping("{projectId}")
    public void approveProject (@RequestParam (value = "roleId", required = false) Long roleInProjectId){

    }

    @PutMapping("{projectId}")
    public void modifyApprovement (){

    }

    @PostMapping("/new")
    public void sExp (){

        Map<String, Object> newBim = new LinkedHashMap<>();
        newBim.put("id","");
        newBim.put("projectCodeNumber","SE-8");
        newBim.put("projectName","Exp 8 from Proxy Orchestrator");
        newBim.put("lod","500");
        newBim.put("projectTypeId","");
        newBim.put("eirId","");
        newBim.put("link","/httl/ddd/r8d8f8u8q8");
        proxyBimService.save(newBim);
    }

    @DeleteMapping ("/del")
    public void dExp (){
        proxyBimService.delete(16L);
    }
}
