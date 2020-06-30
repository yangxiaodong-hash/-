package com.xd.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class flowBean {

    private Integer id;
    private Integer sid;
    private Double qjtime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH")
    private Date ktime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH")
    private Date jtime;
    private String qjcause;
    private Integer qjstatus;
//    请假发起时间
    private Date qjdate=new Date();

    public Date getQjdate() {
        return qjdate;
    }

    public void setQjdate(Date qjdate) {
        this.qjdate = qjdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Double getQjtime() {
        return qjtime;
    }

    public void setQjtime(Double qjtime) {
        this.qjtime = qjtime;
    }

    public Date getKtime() {
        return ktime;
    }

    public void setKtime(Date ktime) {
        this.ktime = ktime;
    }

    public Date getJtime() {
        return jtime;
    }

    public void setJtime(Date jtime) {
        this.jtime = jtime;
    }

    public String getQjcause() {
        return qjcause;
    }

    public void setQjcause(String qjcause) {
        this.qjcause = qjcause;
    }

    public Integer getQjstatus() {
        return qjstatus;
    }

    public void setQjstatus(Integer qjstatus) {
        this.qjstatus = qjstatus;
    }
}
