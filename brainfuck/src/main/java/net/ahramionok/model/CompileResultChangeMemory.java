package net.ahramionok.model;

import java.util.List;

/**
 * Created by KIrill on 23.12.2016.
 */
public class CompileResultChangeMemory {
    private int idProject;
    private String compileResult;
    private String date;
    private List<String> memory;

    public CompileResultChangeMemory() {
    }

    public CompileResultChangeMemory(int idProject, String compileResult, String date, List<String> memory) {

        this.idProject = idProject;
        this.compileResult = compileResult;
        this.date = date;
        this.memory = memory;
    }

    public List<String> getMemory() {

        return memory;
    }

    public void setMemory(List<String> memory) {
        this.memory = memory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompileResult() {
        return compileResult;
    }

    public void setCompileResult(String compileResult) {
        this.compileResult = compileResult;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
}
