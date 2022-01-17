package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle.key.ProjectApprovalCompositeKey;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * ProjectApproval - Binding entity: bim_id (from MultiChiefConstruction), employee_id (from MultiChiefStaff).
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "PROJECT_APPROVAL")
@IdClass(ProjectApprovalCompositeKey.class)
public class ProjectApproval {

    @Id
    @Column(name = "bim_id")
    private Long bimId;

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_in_project_id", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = { "approvals" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private RoleInProject roleInProject;

    @Column(name = "approval_date")
    private LocalDateTime approvalDate;

    public ProjectApproval() {
    }

    public ProjectApproval(Long bimId, Long employeeId, RoleInProject roleInProject, LocalDateTime approvalDate) {
        this.bimId = bimId;
        this.employeeId = employeeId;
        this.roleInProject = roleInProject;
        this.approvalDate = approvalDate;
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

    public RoleInProject getRoleInProject() {
        return roleInProject;
    }

    public void setRoleInProject(RoleInProject roleInProject) {
        this.roleInProject = roleInProject;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }
}
