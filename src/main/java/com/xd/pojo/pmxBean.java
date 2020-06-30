package com.xd.pojo;

import java.util.Date;

public class pmxBean {

    private Integer id;
    private Integer fid;
    private Integer userid;
    private Integer status;
    private Integer pstatus;
    private Integer pshunxu;
//    审批时间
    private Date spdate=new Date();

    public Date getSpdate() {
        return spdate;
    }

    public void setSpdate(Date spdate) {
        this.spdate = spdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPstatus() {
        return pstatus;
    }

    public void setPstatus(Integer pstatus) {
        this.pstatus = pstatus;
    }

    public Integer getPshunxu() {
        return pshunxu;
    }

    public void setPshunxu(Integer pshunxu) {
        this.pshunxu = pshunxu;
    }
}
