package com.sqc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Categ1IndexWithPharm {
    private Integer id;

    private String categId;

    private String pharmId;

    private Float categIndex;

    private Float days;

    private Float sales;

    private Date statisDate;
    
    private  Category category;

    private  Pharmacy pharmacy;
    
    private  Categ1Index categ1Index;
    

    public Categ1Index getCateg1Index() {
		return categ1Index;
	}

	public void setCateg1Index(Categ1Index categ1Index) {
		this.categ1Index = categ1Index;
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

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategId() {
        return categId;
    }

    public void setCategId(String categId) {
        this.categId = categId == null ? null : categId.trim();
    }

    public String getPharmId() {
        return pharmId;
    }

    public void setPharmId(String pharmId) {
        this.pharmId = pharmId == null ? null : pharmId.trim();
    }
    
    @NumberFormat(pattern="####.###")  
    @JsonFormat(pattern="####.###")
    public Float getCategIndex() {
        return categIndex;
    }

    public void setCategIndex(Float categIndex) {
        this.categIndex = categIndex;
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