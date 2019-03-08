package com.sqc.bean;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Pharmacy {
    private String pharmId;

    private String password;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{2,30}$)|(^[\u2E80-\u9FFF0-9_-]{2,30})",
    		message="药店名称必须是2-30位中文、数字和字母的组合")
    private String pharmName;

    private String contactName;

    private String phone;

    private String pharmAddress;

    private String districtId;
    
    private District district;

    private Date startTime;

    private String licenseNo;

   

    private Date addTime;

    private String addUser;

    private Boolean ifDeleted;

    private String deleteUser;

    public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getPharmId() {
        return pharmId;
    }

    public void setPharmId(String pharmId) {
        this.pharmId = pharmId == null ? null : pharmId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPharmName() {
        return pharmName;
    }

    public void setPharmName(String pharmName) {
        this.pharmName = pharmName == null ? null : pharmName.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPharmAddress() {
        return pharmAddress;
    }

    public void setPharmAddress(String pharmAddress) {
        this.pharmAddress = pharmAddress == null ? null : pharmAddress.trim();
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId == null ? null : districtId.trim();
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")  
    @JsonFormat(pattern="yyyy-MM-dd") 
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
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
		return "Pharmacy [pharmId=" + pharmId + ", pharmName=" + pharmName + ", contactName=" + contactName + ", phone="
				+ phone + ", pharmAddress=" + pharmAddress + ", districtId=" + districtId + ", startTime=" + startTime
				+ ", licenseNo=" + licenseNo + "]";
	}
    
    
}