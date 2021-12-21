package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.ProjectApproval;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation.ProjectApprovalService;

/**
 * MCEngineeringFunctionOrchestrator API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1-0
 */

@Controller
@RequestMapping("/api/v1-0/projects")
public class ProjectApprovalController {

    private ProjectApprovalService projectApprovalService;

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
}
