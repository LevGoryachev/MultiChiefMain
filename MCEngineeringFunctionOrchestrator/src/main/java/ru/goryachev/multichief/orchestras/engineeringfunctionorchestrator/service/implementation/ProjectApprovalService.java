package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.ProjectApproval;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.repository.ProjectApprovalRepository;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.BundleService;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.ConstructionMicroServiceConnector;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.StaffMicroServiceConnector;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectApprovalService implements BundleService {

    private ProjectApprovalRepository projectApprovalRepository;
    private ConstructionMicroServiceConnector constructionConnector;
    private StaffMicroServiceConnector staffConnector;

    @Autowired
    public ProjectApprovalService(ProjectApprovalRepository projectApprovalRepository, ConstructionMicroServiceConnector constructionConnector, StaffMicroServiceConnector staffConnector) {
        this.projectApprovalRepository = projectApprovalRepository;
        this.constructionConnector = constructionConnector;
        this.staffConnector = staffConnector;
    }

    public Iterable<ProjectApproval> getAllProjects (){
        return projectApprovalRepository.findAll();
    }


    //getBundle()
    public Map<String, Object> getProject (Long bimId) {
        Map<String, Object> responseDTO = new LinkedHashMap<>();
        responseDTO.put("project", constructionConnector.getBim(bimId)); //set target BIM (construction project) to response from Construction microservice

        List<ProjectApproval> projectApprovals = projectApprovalRepository.getAllByBimId(bimId); //bind-entities(ids) from bind table, filtered by one (target) BIM

        List<Long> employeeIds = projectApprovals.stream().map(ProjectApproval::getEmployeeId).collect(Collectors.toList()); //employeIDs, filtered by one (target) BIM

        List<Object> employeesAll = staffConnector.getAllEmployees(); //get all employees from Staff microservice

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<Object, Object>> employeesAllMapped = employeesAll.stream().map(n -> (Map<Object, Object>) objectMapper.convertValue(n, Map.class)).collect(Collectors.toList()); //convert to Map (LinkedHashMap)

        List<Map<Object, Object>> employeesFiltered = employeesAllMapped.stream().filter(employee -> employeeIds.contains(Long.valueOf(employee.get("id").toString()))).collect(Collectors.toList()); //filter employees by employeIDs, related in this (target) BIM
        responseDTO.put("approvers", employeesFiltered); //set employees which related to the target BIM
        return responseDTO;
    }

    //saveBundle()
    public Map<String, Object> approveProject (Long projectId, Long employeeId, Long roleInProjectId){

        //empoyeeID form where?

        //Transaction ?
        //get Bim (exists) from MCConstruction ?
        //get Employee (exists) from MCEmployee ?
        //catch exception roleInProjectId doesn't exist
        //projectApprovalRepository.save(ProjectApproval)

        return null;
    }

    //deleteBundle
    public void deleteProject (){

    }

}
