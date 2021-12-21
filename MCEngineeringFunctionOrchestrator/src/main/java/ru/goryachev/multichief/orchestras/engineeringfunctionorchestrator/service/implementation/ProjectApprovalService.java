package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.ProjectApproval;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.repository.ProjectApprovalRepository;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.BundleService;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.ConstructionMicroServiceConnector;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.StaffMicroServiceConnector;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ProjectApprovalService implements BundleService {

    private ProjectApprovalRepository projectApprovalRepository;
    private ConstructionMicroServiceConnector constructionConnector;
    private StaffMicroServiceConnector staffConnector;

    Long empId = 1L;

    @Autowired
    public ProjectApprovalService(ProjectApprovalRepository projectApprovalRepository, ConstructionMicroServiceConnector constructionConnector, StaffMicroServiceConnector staffConnector) {
        this.projectApprovalRepository = projectApprovalRepository;
        this.constructionConnector = constructionConnector;
        this.staffConnector = staffConnector;
    }

    public Iterable<ProjectApproval> getAllProjects (){
        return projectApprovalRepository.findAll();
    }

    public Map<String, Object> getProject (Long id) {
        Map<String, Object> responseDTO = new LinkedHashMap<>();
        //get from Construction microservice and put to map (whole their DTO e.g. BimPreformDto)
        //get from Staff microservice and put to map
        //etc. ???

        responseDTO.put("fromConstructionMicroservice", constructionConnector.getConstructionJson(id));
        responseDTO.put("fromStaffMicroservice", staffConnector.getEmployeeJson(empId));
        //responseDTO.put("key","opap aopa");
        return responseDTO;
    }
}
