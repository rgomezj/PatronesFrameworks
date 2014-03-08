package Entities;

public class CreditCard {
	
	private String number;
	private String fullName;
	private int dueYear;
	private int dueMonth;
	private String countryName;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getDueYear() {
		return dueYear;
	}

	public void setDueYear(int dueYear) {
		this.dueYear = dueYear;
	}

	public int getDueMonth() {
		return dueMonth;
	}

	public void setDueMonth(int dueMonth) {
		this.dueMonth = dueMonth;
	}
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
