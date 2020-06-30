package com.xd.pojo;

public class Dept {

    private int deptid;
    private String dname;

    @Override
    public String toString() {
        return "Dept{" +
                "deptid=" + deptid +
                ", dname='" + dname + '\'' +
                '}';
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
