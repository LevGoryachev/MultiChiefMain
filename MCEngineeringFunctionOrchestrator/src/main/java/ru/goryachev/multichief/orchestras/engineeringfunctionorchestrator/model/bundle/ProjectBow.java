package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle;

import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.key.ProjectBowCompositeKey;

import javax.persistence.*;

/**
 * ProjectBow - Binding entity: bim_id (from MultiChiefConstruction), bow_id (from MultiChiefWorkflow).
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "project_approval")
@IdClass(ProjectBowCompositeKey.class)
public class ProjectBow {

    @Id
    @Column(name = "bim_id")
    private Long bimId;

    @Id
    @Column(name = "bow_id")
    private Long bowId;

    public ProjectBow() {
    }

    public ProjectBow(Long bimId, Long bowId) {
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
