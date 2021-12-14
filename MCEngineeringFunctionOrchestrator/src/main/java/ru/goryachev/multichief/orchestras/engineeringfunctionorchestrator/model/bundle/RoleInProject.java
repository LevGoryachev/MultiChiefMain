package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.model.bundle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * RoleInProject
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "role_in_project")
public class RoleInProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_in_project_id")
    private Long id;

    @Column(name = "role_in_project_name")
    private String roleInProjectName;

    @OneToMany(mappedBy = "roleInProject", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "role_in_project" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private List<ProjectApproval> approvals;

    public RoleInProject (){
    }

    public RoleInProject(String roleInProjectName, List<ProjectApproval> approvals) {
        this.roleInProjectName = roleInProjectName;
        this.approvals = approvals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleInProjectName() {
        return roleInProjectName;
    }

    public void setRoleInProjectName(String roleInProjectName) {
        this.roleInProjectName = roleInProjectName;
    }

    public List<ProjectApproval> getApprovals() {
        return approvals;
    }

    public void setApprovals(List<ProjectApproval> approvals) {
        this.approvals = approvals;
    }
}
