package com.sqc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Categ4IndexWithPharm {
    private Long id;

    private String pharmId;

    private String categId;

    private Float categIndex;

    private Float categAvgPrice;

    private Float days;

    private Float sales;

    private Date statisDate;
    
    private  Category category;

    private  Pharmacy pharmacy;
    
    private Categ4Index categ4Index;

    
    
    public Categ4Index getCateg4Index() {
		return categ4Index;
	}

	public void setCateg4Index(Categ4Index categ4Index) {
		this.categ4Index = categ4Index;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

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

    public String getPharmId() {
        return pharmId;
    }

    public void setPharmId(String pharmId) {
        this.pharmId = pharmId == null ? null : pharmId.trim();
    }

    public String getCategId() {
        return categId;
    }

    public void setCategId(String categId) {
        this.categId = categId == null ? null : categId.trim();
    }

    public Float getCategIndex() {
        return categIndex;
    }

    public void setCategIndex(Float categIndex) {
        this.categIndex = categIndex;
    }

    public Float getCategAvgPrice() {
        return categAvgPrice;
    }

    public void setCategAvgPrice(Float categAvgPrice) {
        this.categAvgPrice = categAvgPrice;
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