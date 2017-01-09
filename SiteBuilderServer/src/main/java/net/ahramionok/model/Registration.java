package net.ahramionok.model;

/**
 * Created by KIrill on 08.01.2017.
 */
public class Registration {
    String password;
    String confirmPassword;
    String email;
    String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Registration() {

    }

    public Registration(String password, String confirmPassword, String email, String userName) {

        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.userName = userName;
    }
}
