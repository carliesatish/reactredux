package org.satsinfo.com;

public class SourceBeanClass {
	
	private String fname;
	private String lname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public DOB getDob() {
		return dob;
	}
	public void setDob(DOB dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "SourceBeanClass [fname=" + fname + ", lname=" + lname + ", dob=" + dob + "]";
	}
	private DOB dob;

}
