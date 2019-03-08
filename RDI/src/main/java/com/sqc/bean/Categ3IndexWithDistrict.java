package com.sqc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Categ3IndexWithDistrict {
    private Integer id;

    private String categId;

    private String districtId;

    private Float categIndex;

    private Float days;

    private Float sales;

    private Date statisDate;
    
    private Category category;
    
    private District district;
    
    private  Categ3Index categ3Index;
    
    

   

    public Categ3Index getCateg3Index() {
		return categ3Index;
	}

	public void setCateg3Index(Categ3Index categ3Index) {
		this.categ3Index = categ3Index;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
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

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId == null ? null : districtId.trim();
    }

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