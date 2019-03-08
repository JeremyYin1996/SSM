/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ÏÂÎç2:00:09
 */

package com.phone.domain;

import java.sql.Date;

public class AccountAndSupplier {
	int accountId;
	String accountName;
	int accountNums;
	double accountMoney;
	boolean IsPayed;
	String supplierName;
	String info;
	Date accountDate;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountNums() {
		return accountNums;
	}
	public void setAccountNums(int accountNums) {
		this.accountNums = accountNums;
	}
	public double getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(double accountMoney) {
		this.accountMoney = accountMoney;
	}
	public boolean isIsPayed() {
		return IsPayed;
	}
	public void setIsPayed(boolean isPayed) {
		IsPayed = isPayed;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	
}
