package spring.turbo.examples.valueobject;

import spring.turbo.bean.valueobject.Alias;
import spring.turbo.format.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Long id;

    @Alias(from = "用户名")
    private String username;

    @Alias(from = "密码原文")
    @NotEmpty(message = "密码原文不可为空")
    private String password;

    @Alias(from = "权限")
    @NotEmpty(message = "权限不可为空")
    private String roles;

    @Alias(from = "出生日期")
    @DateTimeFormat
    @Past(message = "出生日期非法")
    private Date dob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", dob=" + dob +
                '}';
    }
}
