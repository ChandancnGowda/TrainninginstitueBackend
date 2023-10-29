package com.ntt.domain;

public class Feedback {
	private int User_id;
	private int Id;
	private String Feedback ;
	public Feedback(int user_id, int id, String feedback) {
		super();
		User_id = user_id;
		Id = id;
		Feedback = feedback;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFeedback() {
		return Feedback;
	}
	public void setFeedback(String feedback) {
		Feedback = feedback;
	}
	@Override
	public String toString() {
		return "Feedback [User_id=" + User_id + ", Id=" + Id + ", Feedback=" + Feedback + "]";
	}
	
}
