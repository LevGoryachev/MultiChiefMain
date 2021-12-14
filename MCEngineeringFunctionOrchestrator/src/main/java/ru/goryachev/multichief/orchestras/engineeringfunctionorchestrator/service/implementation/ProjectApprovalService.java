package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.ProjectApproval;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.repository.ProjectApprovalRepository;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.BundleService;

@Service
public class ProjectApprovalService implements BundleService {

    private ProjectApprovalRepository projectApprovalRepository;

    @Autowired
    public ProjectApprovalService(ProjectApprovalRepository projectApprovalRepository) {
        this.projectApprovalRepository = projectApprovalRepository;
    }

    public Iterable<ProjectApproval> getAllProjects (){
        return projectApprovalRepository.findAll();
    }
}
