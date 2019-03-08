/**
 * @author Jeremy
 * @date 2019-1-8
 * @time ÏÂÎç3:12:57
 */

public class Student {
	String stuName;
	String phoneNumber;
	int stuNo;
	double score;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getStuNumber() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", phoneNumber=" + phoneNumber
				+ ", stuName=" + stuName + ", score=" + score + "]";
	}
}
