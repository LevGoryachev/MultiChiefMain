package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle;

import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.key.ProjectBomCompositeKey;

import javax.persistence.*;

/**
 * ProjectBom - Binding entity: bim_id (from MultiChiefConstruction), bom_id (MultiChiefInventory).
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "project_bom")
@IdClass(ProjectBomCompositeKey.class)
public class ProjectBom {

    @Id
    @Column(name = "bim_id")
    private Long bimId;

    @Id
    @Column(name = "bom_id")
    private Long bowId;

    public ProjectBom() {
    }

    public ProjectBom(Long bimId, Long bowId) {
        this.bimId = bimId;
        this.bowId = bowId;
    }

    public Long getBimId() {
        return bimId;
    }

    public void setBimId(Long bimId) {
        this.bimId = bimId;
    }

    public Long getBowId() {
        return bowId;
    }

    public void setBowId(Long bowId) {
        this.bowId = bowId;
    }
}
