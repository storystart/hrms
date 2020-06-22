package com.xtu.hrms.bean;

import java.util.Date;

public class Emptransfer {
    private Integer id;
    private Integer eid;
    private Integer TDeptId;
    private Integer TPid;
    private Date TDate;
    private String TReason;
    private String remark;

    public Emptransfer() {
    }

    public Emptransfer(Integer id, Integer eid, Integer TDeptId, Integer TPid, Date TDate, String TReason, String remark) {
        this.id = id;
        this.eid = eid;
        this.TDeptId = TDeptId;
        this.TPid = TPid;
        this.TDate = TDate;
        this.TReason = TReason;
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

    public Integer getTDeptId() {
        return TDeptId;
    }

    public void setTDeptId(Integer TDeptId) {
        this.TDeptId = TDeptId;
    }

    public Integer getTPid() {
        return TPid;
    }

    public void setTPid(Integer TPid) {
        this.TPid = TPid;
    }

    public Date getTDate() {
        return TDate;
    }

    public void setTDate(Date TDate) {
        this.TDate = TDate;
    }

    public String getTReason() {
        return TReason;
    }

    public void setTReason(String TReason) {
        this.TReason = TReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
