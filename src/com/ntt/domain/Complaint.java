package com.ntt.domain;

public class Complaint {
	private int Complaint_ID;
	private String Institute_name;
	private int User_id;
	private String Complaint;
	public Complaint(int complaint_ID, String institute_name, int user_id, String complaint) {
		super();
		Complaint_ID = complaint_ID;
		Institute_name = institute_name;
		User_id = user_id;
		Complaint = complaint;
	}
	public int getComplaint_ID() {
		return Complaint_ID;
	}
	public void setComplaint_ID(int complaint_ID) {
		Complaint_ID = complaint_ID;
	}
	public String getInstitute_name() {
		return Institute_name;
	}
	public void setInstitute_name(String institute_name) {
		Institute_name = institute_name;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getComplaint() {
		return Complaint;
	}
	public void setComplaint(String complaint) {
		Complaint = complaint;
	}
	@Override
	public String toString() {
		return "Complaint [Complaint_ID=" + Complaint_ID + ", Institute_name=" + Institute_name + ", User_id=" + User_id
				+ ", Complaint=" + Complaint + "]";
	}
	
	
	
	
}
