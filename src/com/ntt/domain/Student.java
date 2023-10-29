package com.ntt.domain;

public class Student {
	private String Name;
	private String Qualification;
	private String Password;
	private String Contact_number;
	private String Address;
	private String Email_id;
	private int User_id;
	private String Institute_name;
	private int Approved;
	private int Request;
	
	public Student(String name, String qualification, String password, String contact_number, String address,
			String email_id, int user_id, String institute_name, int approved, int request) {
		super();
		Name = name;
		Qualification = qualification;
		Password = password;
		Contact_number = contact_number;
		Address = address;
		Email_id = email_id;
		User_id = user_id;
		Institute_name = institute_name;
		Approved = approved;
		Request = request;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getContact_number() {
		return Contact_number;
	}
	public void setContact_number(String contact_number) {
		Contact_number = contact_number;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getInstitute_name() {
		return Institute_name;
	}
	public void setInstitute_name(String institute_name) {
		Institute_name = institute_name;
	}
	public int getApproved() {
		return Approved;
	}
	public void setApproved(int approved) {
		Approved = approved;
	}
	public int getRequest() {
		return Request;
	}
	public void setRequest(int request) {
		Request = request;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", Qualification=" + Qualification + ", Password=" + Password
				+ ", Contact_number=" + Contact_number + ", Address=" + Address + ", Email_id=" + Email_id
				+ ", User_id=" + User_id + ", Institute_name=" + Institute_name + ", Approved=" + Approved
				+ ", Request=" + Request + "]";
	}
	
	
	
}
