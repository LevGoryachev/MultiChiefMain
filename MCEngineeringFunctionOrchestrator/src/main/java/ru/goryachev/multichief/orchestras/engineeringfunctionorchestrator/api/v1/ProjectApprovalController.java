package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.ProjectApproval;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation.ProjectApprovalService;
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

    private ProjectApprovalService projectApprovalService;

    //todo delete this after
    @Autowired
    private ProxyBimService proxyBimService;

    @Autowired
    public ProjectApprovalController(ProjectApprovalService projectApprovalService) {
        this.projectApprovalService = projectApprovalService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ProjectApproval>> getAllProjects (){
        return new ResponseEntity<>(projectApprovalService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("{projectId}")
    public ResponseEntity<Object> getProject (@PathVariable Long projectId){
        return new ResponseEntity<>(projectApprovalService.getProject(projectId), HttpStatus.OK);
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
        newBim.put("projectCodeNumber","SE-2");
        newBim.put("projectName","Exp from Proxy Orchestrator");
        newBim.put("lod","300");
        newBim.put("projectTypeId","");
        newBim.put("eirId","");
        newBim.put("link","/httl/ddd/xxx/yyyy");
        proxyBimService.saveBim(newBim);
    }
}
