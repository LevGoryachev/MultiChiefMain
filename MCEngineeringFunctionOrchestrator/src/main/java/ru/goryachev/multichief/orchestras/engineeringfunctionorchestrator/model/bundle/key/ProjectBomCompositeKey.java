package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.key;

import java.io.Serializable;

/**
 * ProjectBomCompositeKey - composite key class
 * @author Lev Goryachev
 * @version 1.0
 */

public class ProjectBomCompositeKey implements Serializable {

    Long bimId;

    Long bomId;

    public ProjectBomCompositeKey() {
    }

    public ProjectBomCompositeKey(Long bimId, Long bomId) {
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
