package net.ahramionok.model;

/**
 * Created by KIrill on 23.12.2016.
 */
public class CompileMemory {
    private int idProject;
    private String content;
    private String memory;
    private String date;

    public CompileMemory(int idProject, String content, String memory, String date) {
        this.idProject = idProject;
        this.content = content;
        this.memory = memory;
        this.date = date;
    }

    public CompileMemory() {
    }

    public String getMemory() {

        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }



    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}
