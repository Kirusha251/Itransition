package net.ahramionok.model;

import java.util.List;

/**
 * @author Kirill Achramionok
 */
public class CompileResultBreakPoint {
    private String date;
    private List<String> compileResult;
    private int idProject;

    public CompileResultBreakPoint(String date, List<String> compileResult, int idProject) {
        this.date = date;
        this.compileResult = compileResult;
        this.idProject = idProject;
    }

    public CompileResultBreakPoint() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getCompileResult() {
        return compileResult;
    }

    public void setCompileResult(List<String> compileResult) {
        this.compileResult = compileResult;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
}
