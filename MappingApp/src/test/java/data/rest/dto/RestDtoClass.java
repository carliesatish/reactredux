package data.rest.dto;

public class RestDtoClass {
	private String fFameX9;
	private String lNameX9;
	private DOB dobX9;
	public String getfFameX9() {
		return fFameX9;
	}
	public void setfFameX9(String fFameX9) {
		this.fFameX9 = fFameX9;
	}
	public String getlNameX9() {
		return lNameX9;
	}
	public void setlNameX9(String lNameX9) {
		this.lNameX9 = lNameX9;
	}
	public DOB getDobX9() {
		return dobX9;
	}
	public void setDobX9(DOB dobX9) {
		this.dobX9 = dobX9;
	}
	@Override
	public String toString() {
		return "RestDtoClass [fFameX9=" + fFameX9 + ", lNameX9=" + lNameX9 + ", dobX9=" + dobX9 + "]";
	}
	

}
