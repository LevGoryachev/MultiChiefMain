package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.ProjectBom;

/**
 * ProjectBomRepository: CRUD operations of binding entity.
 * @author Lev Goryachev
 * @version 1.0
 */
@Repository
public interface ProjectBomRepository extends JpaRepository<ProjectBom, Long> {

}
