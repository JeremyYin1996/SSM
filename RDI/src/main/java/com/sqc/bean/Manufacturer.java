package com.sqc.bean;

import java.util.Date;

public class Manufacturer {
    private String manuId;

    private String manuName;

    private String manuAdress;

    private String manuPhone;

    private Date addTime;

    private String addUser;

    private Boolean ifDeleted;

    private String deleteUser;

    public String getManuId() {
        return manuId;
    }

    public void setManuId(String manuId) {
        this.manuId = manuId == null ? null : manuId.trim();
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName == null ? null : manuName.trim();
    }

    public String getManuAdress() {
        return manuAdress;
    }

    public void setManuAdress(String manuAdress) {
        this.manuAdress = manuAdress == null ? null : manuAdress.trim();
    }

    public String getManuPhone() {
        return manuPhone;
    }

    public void setManuPhone(String manuPhone) {
        this.manuPhone = manuPhone == null ? null : manuPhone.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    public Boolean getIfDeleted() {
        return ifDeleted;
    }

    public void setIfDeleted(Boolean ifDeleted) {
        this.ifDeleted = ifDeleted;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser == null ? null : deleteUser.trim();
    }
}