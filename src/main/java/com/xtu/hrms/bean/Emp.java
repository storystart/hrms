package com.xtu.hrms.bean;

import java.util.Date;

public class Emp {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private String IDCard;
    private String wedlock;
    private Integer nationId;
    private String nativePlace;
    private String email;
    private String phone;
    private String address;
    private Integer deptId;
    private Integer posId;
    private String degree;
    private String school;
    private Date edate;
    private String workState;
    private String workID;
    private Date conversionTime;
    private Integer workAge;
    private Date notWorkDate;

    private Nation nation;
    private Position position;
    private Dept dept;

    public Emp() {

    }

    public Emp(Integer id, String name, Integer age, String gender, Date birthday, String IDCard, String wedlock, Integer nationId, String nativePlace, String email, String phone, String address, Integer deptId, Integer posId, String degree, String school, Date edate, String workState, String workID, Date conversionTime, Integer workAge, Date notWorkDate, Nation nation, Position position, Dept dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.IDCard = IDCard;
        this.wedlock = wedlock;
        this.nationId = nationId;
        this.nativePlace = nativePlace;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.deptId = deptId;
        this.posId = posId;
        this.degree = degree;
        this.school = school;
        this.edate = edate;
        this.workState = workState;
        this.workID = workID;
        this.conversionTime = conversionTime;
        this.workAge = workAge;
        this.notWorkDate = notWorkDate;
        this.nation = nation;
        this.position = position;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public Date getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

    public Date getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", IDCard='" + IDCard + '\'' +
                ", wedlock='" + wedlock + '\'' +
                ", nationId=" + nationId +
                ", nativePlace='" + nativePlace + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", deptId=" + deptId +
                ", posId=" + posId +
                ", degree='" + degree + '\'' +
                ", school='" + school + '\'' +
                ", edate=" + edate +
                ", workState='" + workState + '\'' +
                ", workID='" + workID + '\'' +
                ", conversionTime=" + conversionTime +
                ", workAge=" + workAge +
                ", notWorkDate=" + notWorkDate +
                ", nation=" + nation +
                ", position=" + position +
                ", dept=" + dept +
                '}';
    }
}
