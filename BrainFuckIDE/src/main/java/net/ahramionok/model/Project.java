package net.ahramionok.model;

import javax.persistence.*;

/**
 * Created by Kirill on 07.12.2016.
 */
@Entity
public class Project {
    private Integer idProject;
    private String projectContent;
    private String projectName;
    private String compileResult;
    private Byte isLastOpened;
    private User userByIdUser;

    @Id
    @Column(name = "id_project")
    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "project_content")
    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    @Basic
    @Column(name = "project_name")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "compile_result")
    public String getCompileResult() {
        return compileResult;
    }

    public void setCompileResult(String compileResult) {
        this.compileResult = compileResult;
    }

    @Basic
    @Column(name = "is_last_opened")
    public Byte getIsLastOpened() {
        return isLastOpened;
    }

    public void setIsLastOpened(Byte isLastOpened) {
        this.isLastOpened = isLastOpened;
    }


    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }
}
