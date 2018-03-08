package data.rest.dto;

public class DOB {
	private int dateX9;
	private int monthX9;
	private int yearX9;
	public int getDateX9() {
		return dateX9;
	}
	public void setDateX9(int dateX9) {
		this.dateX9 = dateX9;
	}
	public int getMonthX9() {
		return monthX9;
	}
	public void setMonthX9(int monthX9) {
		this.monthX9 = monthX9;
	}
	public int getYearX9() {
		return yearX9;
	}
	public void setYearX9(int yearX9) {
		this.yearX9 = yearX9;
	}
	@Override
	public String toString() {
		return "DOB [dateX9=" + dateX9 + ", monthX9=" + monthX9 + ", yearX9=" + yearX9 + "]";
	}

}
