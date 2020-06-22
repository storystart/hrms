package com.xtu.hrms.bean;

import java.util.Date;

public class Emptrain {
    private Integer id;
    private Integer eid;
    private Date trainDate;
    private String trainContent;
    private String remark;

    private Emp emp;

    public Emptrain() {
    }

    public Emptrain(Integer id, Integer eid, Date trainDate, String trainContent, String remark) {
        this.id = id;
        this.eid = eid;
        this.trainDate = trainDate;
        this.trainContent = trainContent;
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

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
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
