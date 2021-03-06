package spring.turbo.examples.valueobject;

import spring.turbo.bean.valueobject.Alias;
import spring.turbo.format.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User implements Serializable {

    private Long id;

    @Alias(from = "用户名")
    private String username;

    @Alias(from = "密码原文")
    private String password;

    @Alias(from = "权限")
    private String roles;

    @Alias(from = "出生日期")
    @DateTimeFormat
    private Date dob;

    @Alias(from = "工资")
    private BigDecimal salary;

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", dob=" + dob +
                ", salary=" + salary +
                '}';
    }

}
