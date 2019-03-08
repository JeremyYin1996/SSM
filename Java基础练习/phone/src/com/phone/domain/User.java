/**
 * @author Jeremy
 * @date 2019-1-8
 * @time ÏÂÎç7:01:27
 */

package com.phone.domain;

public class User {
	int userId;
	String USER;
	String PASSWORD;
	String LEVEL;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUSER() {
		return USER;
	}
	public void setUSER(String uSER) {
		USER = uSER;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getLEVEL() {
		return LEVEL;
	}
	public void setLEVEL(String lEVEL) {
		LEVEL = lEVEL;
	}
	
	@Override
	public String toString() {
		return "Student [USER=" + USER + ", userId=" + userId
				+ ", PASSWORD=" + PASSWORD + ", score=" + LEVEL + "]";
	}
}
