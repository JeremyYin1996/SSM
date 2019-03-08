package com.sqc.bean;

import java.util.Date;

public class Sales {
    private Long id;

    private String drugId;

    private String pharmId;

    private Float salePrice;

    private Integer saleNum;

    private Date statisDate;

    private Date addTime;

    private String addUser;

    private Boolean ifDeleted;

    private String deleteUser;
    
    private Pharmacy pharmacy;

    public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public String getPharmId() {
        return pharmId;
    }

    public void setPharmId(String pharmId) {
        this.pharmId = pharmId == null ? null : pharmId.trim();
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Date getStatisDate() {
        return statisDate;
    }

    public void setStatisDate(Date statisDate) {
        this.statisDate = statisDate;
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