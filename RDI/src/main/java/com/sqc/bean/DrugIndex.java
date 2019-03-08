package com.sqc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DrugIndex {
    private Long id;

    private String drugId;

    private Float drugIndex;

    private Float avgPrice;

    private Float days;

    private Float sales;

    private Date statisDate;
    
    private Drug drug;

    public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
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

    public Float getDrugIndex() {
        return drugIndex;
    }

    public void setDrugIndex(Float drugIndex) {
        this.drugIndex = drugIndex;
    }

    public Float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Float getDays() {
        return days;
    }

    public void setDays(Float days) {
        this.days = days;
    }

    public Float getSales() {
        return sales;
    }

    public void setSales(Float sales) {
        this.sales = sales;
    }

    @DateTimeFormat(pattern="yyyy-MM")  
    @JsonFormat(pattern="yyyy-MM") 
    public Date getStatisDate() {
        return statisDate;
    }

    public void setStatisDate(Date statisDate) {
        this.statisDate = statisDate;
    }
}