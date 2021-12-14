package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.RoleInProject;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.repository.RoleInProjectRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RoleInProjectService {

    private RoleInProjectRepository roleInProjectRepository;

    @Autowired
    public RoleInProjectService(RoleInProjectRepository roleInProjectRepository) {
        this.roleInProjectRepository = roleInProjectRepository;
    }

    public Iterable<RoleInProject> getAllRoles (){
        return roleInProjectRepository.findAll();
    }

    public RoleInProject getByRoleName (String roleName){
        return roleInProjectRepository.getByRoleInProjectName(roleName);
    }

   public Map<String, Object> create (RoleInProject roleInProject) {
        RoleInProject savedRole = roleInProjectRepository.save(roleInProject);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", "Saved in DB");
        responseBody.put("id", savedRole);
        return responseBody;
    }

    public Map<String, Object> update (RoleInProject modifiedRoleInProject) {
        RoleInProject savedRole = roleInProjectRepository.save(modifiedRoleInProject);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", "Saved in DB");
        responseBody.put("id", savedRole);
        return responseBody;
    }

    public Map<String, Object> delete (Long id) {
        roleInProjectRepository.deleteById(id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", "Entity with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
