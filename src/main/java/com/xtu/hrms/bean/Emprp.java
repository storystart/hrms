package com.xtu.hrms.bean;

import java.util.Date;

public class Emprp {
    private Integer id;
    private Integer eid;
    private Date rpDate;
    private String rpType;
    private String rpReason;
    private Integer rpPoint;
    private String  remark;

    private Emp emp;

    public Emprp() {
    }

    public Emprp(Integer id, Integer eid, Date rpDate, String rpType, String rpReason, Integer rpPoint, String remark, Emp emp) {
        this.id = id;
        this.eid = eid;
        this.rpDate = rpDate;
        this.rpType = rpType;
        this.rpReason = rpReason;
        this.rpPoint = rpPoint;
        this.remark = remark;
        this.emp = emp;
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

    public Date getRpDate() {
        return rpDate;
    }

    public void setRpDate(Date rpDate) {
        this.rpDate = rpDate;
    }

    public String getRpReason() {
        return rpReason;
    }

    public void setRpReason(String rpReason) {
        this.rpReason = rpReason;
    }

    public Integer getRpPoint() {
        return rpPoint;
    }

    public void setRpPoint(Integer rpPoint) {
        this.rpPoint = rpPoint;
    }

    public String getRpType() {
        return rpType;
    }

    public void setRpType(String rpType) {
        this.rpType = rpType;
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
