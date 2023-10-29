package com.ntt.domain;

public class Faculty {
	private String Name;
	private int Id;
	private String subject;
	private String Institute_name;
	public Faculty(String name, int id, String subject, String institute_name) {
		super();
		Name = name;
		Id = id;
		this.subject = subject;
		Institute_name = institute_name;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getInstitute_name() {
		return Institute_name;
	}
	public void setInstitute_name(String institute_name) {
		Institute_name = institute_name;
	}
	@Override
	public String toString() {
		return "Faculty [Name=" + Name + ", Id=" + Id + ", subject=" + subject + ", Institute_name=" + Institute_name
				+ "]";
	}
	
	
	
}
