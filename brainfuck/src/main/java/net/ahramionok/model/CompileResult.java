package net.ahramionok.model;

/**
 * @author Kirill Achramionok
 */
public class CompileResult {
    private int idProject;
    private String compileResult;
    private String date;


    public CompileResult(int idProject, String date, String compileResult) {
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
