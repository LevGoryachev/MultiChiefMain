package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.key;

import java.io.Serializable;

/**
 * ProjectBowCompositeKey - composite key class
 * @author Lev Goryachev
 * @version 1.0
 */

public class ProjectBowCompositeKey implements Serializable {

    Long bimId;

    Long bowId;

    public ProjectBowCompositeKey() {
    }

    public ProjectBowCompositeKey(Long bimId, Long bowId) {
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
