package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.repository.ProjectBomRepository;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.BundleService;

@Service
public class BundleProjectBomService implements BundleService {

    private ProjectBomRepository projectBomRepository;

    @Autowired
    public BundleProjectBomService(ProjectBomRepository projectBomRepository) {
        this.projectBomRepository = projectBomRepository;
    }
}
