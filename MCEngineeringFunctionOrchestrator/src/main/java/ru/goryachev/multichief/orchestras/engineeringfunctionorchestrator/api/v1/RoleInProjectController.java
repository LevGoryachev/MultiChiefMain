package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.RoleInProject;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation.RoleInProjectService;

/**
 * MCEngineeringFunctionOrchestrator API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1-0
 */

@RestController
@RequestMapping("/api/v1-0/projects/roles")
public class RoleInProjectController {

    private RoleInProjectService roleInProjectService;

    @Autowired
    public RoleInProjectController(RoleInProjectService roleInProjectService) {
        this.roleInProjectService = roleInProjectService;
    }

    @GetMapping
    public ResponseEntity<Iterable<RoleInProject>> getAllEirs () {
        return new ResponseEntity<>(roleInProjectService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<RoleInProject> getByRoleName (@PathVariable String roleName) {
            return new ResponseEntity<>(roleInProjectService.getByRoleName(roleName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody RoleInProject roleInProject) {
        return new ResponseEntity<>(roleInProjectService.create(roleInProject), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody RoleInProject modifiedRoleInProject) {
        return new ResponseEntity<>(roleInProjectService.create(modifiedRoleInProject), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(roleInProjectService.delete(id), HttpStatus.OK);
    }
}
