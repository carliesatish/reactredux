package org.satsinfo.com;

public class DOB {

	private int date;
	private int month;
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	private int year;
	@Override
	public String toString() {
		return "DOB [date=" + date + ", month=" + month + ", year=" + year + "]";
	}
}
