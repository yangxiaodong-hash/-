package com.xd.pojo;

public class QueryVo {

    private String uname;
    private String pwd;
    private String code;
    private String cardno;

    public QueryVo() {
    }

    public QueryVo(String uname, String pwd, String code) {
        this.uname = uname;
        this.pwd = pwd;
        this.code = code;

    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", code='" + code + '\'' +
                ", cardno='" + cardno + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }
}
