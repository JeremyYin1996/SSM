package com.sqc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Temp {
    private Long id;

    private String approvalNumber;

    private Float salePrice;

    private Integer saleNum;

    private Date statisDate;

    private String pharmId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber == null ? null : approvalNumber.trim();
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

    @DateTimeFormat(pattern="yyyy-MM-dd")  
    @JsonFormat(pattern="yyyy-MM-dd") 
    public Date getStatisDate() {
        return statisDate;
    }

    public void setStatisDate(Date statisDate) {
        this.statisDate = statisDate;
    }

    public String getPharmId() {
        return pharmId;
    }

    public void setPharmId(String pharmId) {
        this.pharmId = pharmId == null ? null : pharmId.trim();
    }

	@Override
	public String toString() {
		return "Temp [id=" + id + ", approvalNumber=" + approvalNumber + ", salePrice=" + salePrice + ", saleNum="
				+ saleNum + ", statisDate=" + statisDate + ", pharmId=" + pharmId + "]";
	}
    
    

}