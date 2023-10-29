package com.ntt.domain;

public class Institute {
	private String Institute_name;
	private String Password;
	private String Affiliation_Date;
	private String Address;
	private int Number_of_seats;
	private int Number_of_course;
	private int Approved;
	public Institute(String institute_name, String password, String affiliation_Date, String address,
			int number_of_seats, int number_of_course, int approved) {
		super();
		Institute_name = institute_name;
		Password = password;
		Affiliation_Date = affiliation_Date;
		Address = address;
		Number_of_seats = number_of_seats;
		Number_of_course = number_of_course;
		Approved = approved;
	}
	public String getInstitute_name() {
		return Institute_name;
	}
	public void setInstitute_name(String institute_name) {
		Institute_name = institute_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAffiliation_Date() {
		return Affiliation_Date;
	}
	public void setAffiliation_Date(String affiliation_Date) {
		Affiliation_Date = affiliation_Date;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getNumber_of_seats() {
		return Number_of_seats;
	}
	public void setNumber_of_seats(int number_of_seats) {
		Number_of_seats = number_of_seats;
	}
	public int getNumber_of_course() {
		return Number_of_course;
	}
	public void setNumber_of_course(int number_of_course) {
		Number_of_course = number_of_course;
	}
	public int getApproved() {
		return Approved;
	}
	public void setApproved(int approved) {
		Approved = approved;
	}
	@Override
	public String toString() {
		return "Institute [Institute_name=" + Institute_name + ", Password=" + Password + ", Affiliation_Date="
				+ Affiliation_Date + ", Address=" + Address + ", Number_of_seats=" + Number_of_seats
				+ ", Number_of_course=" + Number_of_course + ", Approved=" + Approved + "]";
	}
	
	
}
