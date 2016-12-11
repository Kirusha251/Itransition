package net.ahramionok.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by KIrill on 11.12.2016.
 */
@Entity
public class Project {
    private int idProject;
    private int idUser;
    private String projectName;
    private String projectContent;
    private String compileResult;
    private byte isLastOpened;

    @Id
    @Column(name = "id_project", nullable = false)
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "project_name", nullable = false, length = 50)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "project_content", nullable = false, length = -1)
    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    @Basic
    @Column(name = "compile_result", nullable = false, length = -1)
    public String getCompileResult() {
        return compileResult;
    }

    public void setCompileResult(String compileResult) {
        this.compileResult = compileResult;
    }

    @Basic
    @Column(name = "is_last_opened", nullable = false)
    public byte getIsLastOpened() {
        return isLastOpened;
    }

    public void setIsLastOpened(byte isLastOpened) {
        this.isLastOpened = isLastOpened;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (idProject != project.idProject) return false;
        if (idUser != project.idUser) return false;
        if (isLastOpened != project.isLastOpened) return false;
        if (projectName != null ? !projectName.equals(project.projectName) : project.projectName != null) return false;
        if (projectContent != null ? !projectContent.equals(project.projectContent) : project.projectContent != null)
            return false;
        if (compileResult != null ? !compileResult.equals(project.compileResult) : project.compileResult != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProject;
        result = 31 * result + idUser;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectContent != null ? projectContent.hashCode() : 0);
        result = 31 * result + (compileResult != null ? compileResult.hashCode() : 0);
        result = 31 * result + (int) isLastOpened;
        return result;
    }
}
