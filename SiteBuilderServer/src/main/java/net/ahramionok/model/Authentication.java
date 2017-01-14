package net.ahramionok.model;

/**
 * Created by KIrill on 07.01.2017.
 */
public class Authentication {
    String email;
    String password;


    public Authentication() {
    }

    public Authentication(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
