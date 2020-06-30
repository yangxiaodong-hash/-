package com.xd.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private Integer id;
    private String username;
    private String password;
    private Integer deptid;
    private Integer rid;

    private String dname;
    private String rname;

    private Integer age;

    private Date userdate;

    private Integer gid;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", deptid=" + deptid +
                ", rid=" + rid +
                ", dname='" + dname + '\'' +
                ", rname='" + rname + '\'' +
                ", age=" + age +
                ", userdate=" + userdate +
                ", gid=" + gid +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getUserdate() {
        return userdate;
    }

    public void setUserdate(Date userdate) {
        this.userdate = userdate;
    }

}
