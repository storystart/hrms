package com.xtu.hrms.bean;

public class Empsalary {
    private Integer id;
    private Integer eid;
    private Integer sid;
    private Double sal;

    private Emp emp;
    private Salary salary;

    public Empsalary() {
    }


    public Empsalary(Integer id, Integer eid, Integer sid, Double sal, Emp emp, Salary salary) {
        this.id = id;
        this.eid = eid;
        this.sid = sid;
        this.sal = sal;
        this.emp = emp;
        this.salary = salary;
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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
