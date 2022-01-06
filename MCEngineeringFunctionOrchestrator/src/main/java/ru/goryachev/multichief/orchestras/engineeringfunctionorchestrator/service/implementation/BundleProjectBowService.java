package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.repository.ProjectBowRepository;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.BundleService;

@Service
public class BundleProjectBowService implements BundleService {

    private ProjectBowRepository projectBowRepository;

    @Autowired
    public BundleProjectBowService(ProjectBowRepository projectBowRepository) {
        this.projectBowRepository = projectBowRepository;
    }
}
