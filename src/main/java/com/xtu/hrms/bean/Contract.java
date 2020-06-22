package com.xtu.hrms.bean;

import java.util.Date;

public class Contract {
    private Integer id;
    private String workID;
    private Double contractTerm;
    private Date beginContract;
    private Date endContract;
    private String contractContent;

    private Emp emp;

    public Contract() {
    }

    public Contract(Integer id, String workID, Double contractTerm, Date beginContract, Date endContract, String contractContent, Emp emp) {
        this.id = id;
        this.workID = workID;
        this.contractTerm = contractTerm;
        this.beginContract = beginContract;
        this.endContract = endContract;
        this.contractContent = contractContent;
        this.emp = emp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public Double getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Double contractTerm) {
        this.contractTerm = contractTerm;
    }

    public Date getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", workID='" + workID + '\'' +
                ", contractTerm=" + contractTerm +
                ", beginContract=" + beginContract +
                ", endContract=" + endContract +
                ", contractContent='" + contractContent + '\'' +
                ", emp=" + emp +
                '}';
    }
}
