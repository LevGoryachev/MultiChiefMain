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

    public Map<String, Object> getProject (Long bimId) {
        Map<String, Object> responseDTO = new LinkedHashMap<>();
        responseDTO.put("Project", constructionConnector.getBimJson(bimId)); //set target BIM (construction project) to response from Construction microservice

        List<ProjectApproval> projectApprovals = projectApprovalRepository.getAllByBimId(bimId); //bind-entities(ids) from bind table, filtered by one (target) BIM

        List<Long> employeeIds = projectApprovals.stream().map(ProjectApproval::getEmployeeId).collect(Collectors.toList()); //employeIDs, filtered by one (target) BIM

        List<Object> employeesAll = staffConnector.getAllEmployees(); //get all employees from Staff microservice

        //convert to Map (LinkedHashMap)
        List<Map<Object, Object>> employeesAllMapped = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for(Object o: employeesAll){
            Map<Object, Object> employeeMap = objectMapper.convertValue(o, Map.class);
            employeesAllMapped.add(employeeMap);
        }
        //employeesAllMapped = employeesAll.stream().map(o -> ObjectMapper::convertValue(o, Map.class)).collect(Collectors.toList());
        //employeesAllMapped = employeesAll.stream().forEach(s -> objectMapper.convertValue(s,Map.class)).collect(Collectors.toList());
        //employeesAllMapped = employeesAll.stream().map(s -> objectMapper.readValue(s, Map.class)).collect(Collectors.toList());

        List<Map<Object, Object>> employeesFiltered = employeesAllMapped.stream().filter(employee -> employeeIds.contains(Long.valueOf(employee.get("id").toString()))).collect(Collectors.toList());
        responseDTO.put("Approvers", employeesFiltered);
        return responseDTO;
    }
}
