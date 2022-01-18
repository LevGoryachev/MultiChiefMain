package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.api.v1_0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.ProjectApproval;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation.BundleProjectApprovalService;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation.ProxyBimService;

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

    @DeleteMapping ("{projectId}")
    public void dExp (){

    }
}
