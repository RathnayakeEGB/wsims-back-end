package org.wwpmo.wsims.models.login;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class LoginInfo implements Serializable {

    @NotNull
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginInfo(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public LoginInfo() {
    }
}
