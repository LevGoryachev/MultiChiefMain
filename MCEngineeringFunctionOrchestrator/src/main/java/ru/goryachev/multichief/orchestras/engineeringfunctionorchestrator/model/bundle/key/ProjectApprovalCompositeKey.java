package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.key;

import java.io.Serializable;

/**
 * ProjectApprovalCompositeKey - composite key class
 * @author Lev Goryachev
 * @version 1.0
 */

public class ProjectApprovalCompositeKey implements Serializable {

    Long bimId;

    Long employeeId;

    public ProjectApprovalCompositeKey() {
    }

    public ProjectApprovalCompositeKey(Long bimId, Long employeeId) {
        this.bimId = bimId;
        this.employeeId = employeeId;
    }

    public Long getBimId() {
        return bimId;
    }

    public void setBimId(Long bimId) {
        this.bimId = bimId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
