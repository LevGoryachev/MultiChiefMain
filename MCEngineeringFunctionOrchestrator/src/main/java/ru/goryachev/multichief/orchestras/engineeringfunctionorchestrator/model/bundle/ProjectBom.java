package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle;

import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.key.ProjectBomCompositeKey;

import javax.persistence.*;

/**
 * ProjectBom - Binding entity: bim_id (from MultiChiefConstruction), bom_id (MultiChiefInventory).
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "PROJECT_BOM")
@IdClass(ProjectBomCompositeKey.class)
public class ProjectBom {

    @Id
    @Column(name = "bim_id")
    private Long bimId;

    @Id
    @Column(name = "bom_id")
    private Long bomId;

    public ProjectBom() {
    }

    public ProjectBom(Long bimId, Long bomId) {
        this.bimId = bimId;
        this.bomId = bomId;
    }

    public Long getBimId() {
        return bimId;
    }

    public void setBimId(Long bimId) {
        this.bimId = bimId;
    }

    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }
}
