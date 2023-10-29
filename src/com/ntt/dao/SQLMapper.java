package com.ntt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ntt.dbfw.ResultMapper;
import com.ntt.domain.Complaint;
import com.ntt.domain.Faculty;
import com.ntt.domain.Feedback;
import com.ntt.domain.Institute;
import com.ntt.domain.Student;



public class SQLMapper {
	
	public static final String REGISTERINSTITUTE="insert into Institute values(?,?,?,?,?,?,?)";
	public static final String FETCHINSTITUTES="select * from Institute";
	public static final String UPDATEINSTITUTEAPPROVAL="update Institute set Approved=? where Institute_name=?" ;
	public static final String DELETEINSTITUTE="delete from Institute where Institute_name=?";
	
	public static final String UPDATEINSTITUTE="update Institute set Institute_name=?,Password=?,Affiliation_Date=?,Address=?,Number_of_seats=?,Number_of_course=? where Institute_name=?";
	
	public static final String REGISTERSTUDENT="insert into Student values(?,?,?,?,?,?,?,?,?,?)";
	public static final String FETCHSTUDENTS="select * from Student";
	public static final String UPDATESTUDENTAPPROVAL="update Student set Approved=? where  User_id=?";
	public static final String RAISEREQUEST="update Student set Request=? where User_id=?";
	
	public static final String UPDATESTUDENT="update Student set Name=?, Qualification=?,"
			+ "Password=?,Contact_number=?, Address=?,Email_id=?,User_id=? where User_id=?";
	

	
	public static final String INSERTCOMPLAINTS="insert into Complaint values(?,?,?,?)";
	public static final String FETCHCOMPLAINTS="select * from Complaint";
	
	
	public static final String INSERTFACULTY="insert into Faculty values(?,?,?,?)";
	
	public static final String INSERTFEEDBACK="insert into Feedback values(?,?,?)";
	public static final String FETCHFEEDBACK="select * from Feedback";
	
	
	
	
	
	public static final ResultMapper INSTITUTEMAPPER=new ResultMapper() {

		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			
			String Institute_name=rs.getString(1);
			String Password=rs.getString(2);
			String Affiliation_Date=rs.getString(3);
			String Address=rs.getString(4);
			int Number_of_seats=rs.getInt(5);
			int Number_of_course=rs.getInt(6);
			int Approved=rs.getInt(7);
			
			Institute i=new Institute(Institute_name,Password, Affiliation_Date, Address,Number_of_seats, Number_of_course, Approved);
			return i;
		}
		
		
	};
	public static final ResultMapper STUDENTMAPPER= new ResultMapper() {

		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			String Name=rs.getString(1);
			String Qualification=rs.getString(2);
			String Password=rs.getString(3);
			String Contact_number=rs.getString(4);
			String Address=rs.getString(5);
			String Email_id=rs.getString(6);
			int User_id=rs.getInt(7);
			String Institute_name=rs.getString(8);
			int Approved=rs.getInt(9);
			int Request=rs.getInt(10);
			Student s=new Student(Name,Qualification,Password,Contact_number, Address,Email_id,User_id,Institute_name,Approved,Request);
			return s;
		}
		
	};
	
	public static final ResultMapper COMPLAINTMAPPER=new ResultMapper() {

		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			
			int Complaint_ID=rs.getInt(1);
			String Institute_name=rs.getString(2);
			int User_id=rs.getInt(3);
			String Complaint=rs.getString(4);
			
			
			Complaint ic=new Complaint(Complaint_ID,Institute_name,User_id,Complaint);
			
			return ic;
		}
		
	};
	public static final ResultMapper FACULTYMAPPER=new ResultMapper() {
	
		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			
			String Name=rs.getString(1);
			int Id=rs.getInt(2);
			String subject=rs.getString(3);
			String Institute_name=rs.getString(4);
			
			Faculty f=new Faculty(Name,Id,subject,Institute_name);
			return f;
		}
		
	};
	
	public static final ResultMapper FEEDBACKMAPPER=new ResultMapper() {
		
		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			
			int User_id=rs.getInt(1);
			int Id=rs.getInt(2);
			String Feedback=rs.getString(3);
			
			Feedback feed=new Feedback(User_id, Id, Feedback);
			return feed ;
		}
	};
	
}









