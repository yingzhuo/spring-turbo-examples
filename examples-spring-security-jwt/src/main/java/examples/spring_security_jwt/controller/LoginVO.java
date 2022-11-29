package examples.spring_security_jwt.controller;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public class LoginVO implements Serializable {

    @NotEmpty(message = "登录用户名不可为空")
    private String username;

    @NotEmpty(message = "登录密码不可为空")
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
}
