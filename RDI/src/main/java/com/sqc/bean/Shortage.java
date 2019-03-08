package com.sqc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Shortage {
    private Integer id;

    private String drugId;

    private String pharmId;

    private Integer shortNum;

    private Date shortDate;

    private Date addTime;

    private String addUser;

    private Boolean ifDeleted;

    private String deleteUser;
    
    private Drug drug;
    
    
    
    

    public Drug getDrug() {
		return drug;
	}



	public void setDrug(Drug drug) {
		this.drug = drug;
	}



	public Shortage() {
		super();
	}
    
    

	public Shortage(String drugId, String pharmId, Integer shortNum, Date shortDate) {
		super();
		this.drugId = drugId;
		this.pharmId = pharmId;
		this.shortNum = shortNum;
		this.shortDate = shortDate;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getShortNum() {
        return shortNum;
    }

    public void setShortNum(Integer shortNum) {
        this.shortNum = shortNum;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")  
    @JsonFormat(pattern="yyyy-MM-dd") 
    public Date getShortDate() {
        return shortDate;
    }

    public void setShortDate(Date shortDate) {
        this.shortDate = shortDate;
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

	@Override
	public String toString() {
		return "Shortage [drugId=" + drugId + ", pharmId=" + pharmId + ", shortNum=" + shortNum + ", shortDate="
				+ shortDate + "]";
	}
    
    
}