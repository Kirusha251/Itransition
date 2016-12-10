package net.ahramionok.web.model;

/**
 * Created by Kirill on 06.12.2016.
 */
public class User {

    private int id;
    private String userName;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.userName = name;
        this.age = age;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
