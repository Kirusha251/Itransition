package net.ahramionok.model;

/**
 * @author Kirill Achramionok
 */
public class Compile {
    private int idProject;
    private String content;
    private String date;

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

    public Compile(int idProject, String content, String date) {

        this.idProject = idProject;
        this.content = content;
        this.date = date;
    }

    public Compile() {

    }


}
