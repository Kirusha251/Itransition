package net.ahramionok.model;

/**
 * @author Kirill Achramionok
 */
public class CompileResult {
    private String date;
    private String compileResult;
    private int idProject;

    public CompileResult(String date, String compileResult, int idProject) {
        this.date = date;
        this.compileResult = compileResult;
        this.idProject = idProject;
    }

    public CompileResult() {

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
