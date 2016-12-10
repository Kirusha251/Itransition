package net.ahramionok.web.model;

/**
 * Created by Kirill on 06.12.2016.
 */
public class Project {
    private int id;
    private String name;
    private String content;
    private String path;
    private boolean isOpened;

    public Project() {
        this.isOpened = false;
    }

    public Project(int id, String name, String content, String path, boolean isOpened) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.path = path;
        this.isOpened = isOpened;
    }

    public boolean isOpened() {

        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
