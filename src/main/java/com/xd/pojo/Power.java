package com.xd.pojo;

public class Power {

    private Integer id;
    private Integer pid;
    private String pname;

    private String icon;
    private String url;
    private String target;

    private boolean Checked=false;

    private String isbutton;

    public String getIsbutton() {
        return isbutton;
    }

    public void setIsbutton(String isbutton) {
        this.isbutton = isbutton;
    }

    @Override
    public String toString() {
        return "Power{" +
                "id=" + id +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", target='" + target + '\'' +
                ", Checked=" + Checked +
                '}';
    }

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
