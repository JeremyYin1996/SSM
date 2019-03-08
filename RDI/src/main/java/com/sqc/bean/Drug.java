package com.sqc.bean;

import java.util.Date;

public class Drug {
    private String drugId;

    private String drugName;

    private String commonDrugName;

    private String englishName;

    private String dosageForm;

    private String atcCode;

    private String approvalNumber;

    private Date approvalValidity;

    private String barCode;

    private String manufacturer;

    private Float specifications;

    private String specUnit;

    private Byte numbers;

    private String numUnit;

    private Float ddd;

    private String categId;

    private String remark;
    
    private String spec;
    
    private  Category category;
    
    
    public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getCommonDrugName() {
        return commonDrugName;
    }

    public void setCommonDrugName(String commonDrugName) {
        this.commonDrugName = commonDrugName == null ? null : commonDrugName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm == null ? null : dosageForm.trim();
    }

    public String getAtcCode() {
        return atcCode;
    }

    public void setAtcCode(String atcCode) {
        this.atcCode = atcCode == null ? null : atcCode.trim();
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber == null ? null : approvalNumber.trim();
    }

    public Date getApprovalValidity() {
        return approvalValidity;
    }

    public void setApprovalValidity(Date approvalValidity) {
        this.approvalValidity = approvalValidity;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Float getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Float specifications) {
        this.specifications = specifications;
    }

    public String getSpecUnit() {
        return specUnit;
    }

    public void setSpecUnit(String specUnit) {
        this.specUnit = specUnit == null ? null : specUnit.trim();
    }

    public Byte getNumbers() {
        return numbers;
    }

    public void setNumbers(Byte numbers) {
        this.numbers = numbers;
    }

    public String getNumUnit() {
        return numUnit;
    }

    public void setNumUnit(String numUnit) {
        this.numUnit = numUnit == null ? null : numUnit.trim();
    }

    public Float getDdd() {
        return ddd;
    }

    public void setDdd(Float ddd) {
        this.ddd = ddd;
    }

    public String getCategId() {
        return categId;
    }

    public void setCategId(String categId) {
        this.categId = categId == null ? null : categId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Drug [drugId=" + drugId + ", drugName=" + drugName + ", dosageForm=" + dosageForm + ", approvalNumber="
				+ approvalNumber + ", barCode=" + barCode + ", manufacturer=" + manufacturer + ", specifications="
				+ specifications + ", specUnit=" + specUnit + ", numbers=" + numbers + ", numUnit=" + numUnit + ", ddd="
				+ ddd + "]";
	}
    
    
}