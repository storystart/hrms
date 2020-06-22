package com.xtu.hrms.bean;

import java.util.Date;

public class Appraise {
    private Integer id;
    private Integer eid;
    private Date appDate;
    private String appResult;
    private String appContent;
    private String remark;

    private Emp emp;

    public Appraise() {
    }

    public Appraise(Integer id, Integer eid, Date appDate, String appResult, String appContent, String remark) {
        this.id = id;
        this.eid = eid;
        this.appDate = appDate;
        this.appResult = appResult;
        this.appContent = appContent;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getAppResult() {
        return appResult;
    }

    public void setAppResult(String appResult) {
        this.appResult = appResult;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
