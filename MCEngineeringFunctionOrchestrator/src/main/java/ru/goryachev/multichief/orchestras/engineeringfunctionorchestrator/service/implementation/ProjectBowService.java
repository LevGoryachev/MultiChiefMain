package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.repository.ProjectBowRepository;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.BundleService;

@Service
public class ProjectBowService implements BundleService {

    private ProjectBowRepository projectBowRepository;

    @Autowired
    public ProjectBowService(ProjectBowRepository projectBowRepository) {
        this.projectBowRepository = projectBowRepository;
    }
}
