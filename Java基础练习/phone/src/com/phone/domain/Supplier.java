/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ÏÂÎç6:23:06
 */

package com.phone.domain;

import java.sql.Date;

public class Supplier {
	int supplierId;
	String supplierName;
	String linkMan;
	String linkPhone;
	String linkAddress;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
		@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName="
				+ supplierName + ", linkMan=" + linkMan + ", linkPhone="
				+ linkPhone + ", linkAddress=" + linkAddress + "]";
	}
	
	
	
}


