package com.ntt.driver;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ntt.dao.InstituteDao;
import com.ntt.dao.InstituteDaoException;
import com.ntt.dao.StudentDao;
import com.ntt.dao.StudentDaoException;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.domain.Complaint;
import com.ntt.domain.Feedback;
import com.ntt.domain.Institute;
import com.ntt.domain.Student;

public class StudentDriver {
	
	public static void Student_Operation(int user_id) throws DBFWException, StudentDaoException, DBConnectionException {
		int ch;
		int status=0;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("STUDENT MENU");
			System.out.println("----------------------------------------------");
			System.out.println("1.Update profile");
			System.out.println("2.Send request to Institute");
			System.out.println("3.View response");
			System.out.println("4.Raise Complaint");
			System.out.println("5.Send feedback ");
			int choice;
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				boolean check=false;
				check=Check_Approval(user_id );
				if(check) {
					List student1=null;
					int result=0;
					String Nname;	String NQualy;	String Npass;	String Ncont;	String Nadd;	 String Nemail;	int Nid;
					//System.out.println("Enter the name of the Student that you want update profile");
					//int id=sc.nextInt();
					student1=StudentDao.getStudent();
					for(Iterator it=student1.iterator();it.hasNext();) {
						Student c1=(Student) it.next();
						if(c1.getUser_id()==user_id) {
							System.out.printf("Enter the New name for Student..! if dont want to keep old name as %s %n",c1.getName());
							Nname=sc.next();
							System.out.printf("Enter the New Qualification..! if dont want to keep old Qualification as %s %n",c1.getQualification());
							NQualy=sc.next();
							System.out.printf("Enter the New Password..! if dont want to keep old Password as %s %n",c1.getPassword());
							Npass=sc.next();
							System.out.printf("Enter the New Contact..! if dont want to keep old Contact as %s %n",c1.getContact_number());
							Ncont=sc.next();
							System.out.printf("Enter the New Address..! if dont want to keep old Address as %s %n",c1.getAddress());
							Nadd=sc.next();
							System.out.printf("Enter the New Email..! if dont want to keep old Email as %s %n",c1.getEmail_id());
							Nemail=sc.next();
							System.out.printf("Enter the New User ID..! if dont want to keep old User ID as %s %n",c1.getUser_id());
							Nid=sc.nextInt();
							
							result=StudentDao.updateStudent(Nname, NQualy, Npass, Ncont, Nadd, Nemail, Nid, user_id);
							
							if(result!=0) {
								
								System.out.println(Nid+" "+Nname+"	Student details are updated successfully");
							}
							else
							{
								System.out.println(c1.getUser_id()+" "+c1.getName()+"	Institute profile Not updated");
							}
						}
						
					}
					
				}
				else {
					System.out.println("Not yet Approved by Institute...! Raise Request to the Institute");
				}
				break;
			case 2:
				List inst=null;
				int res=0;
				int value=0;
				boolean available=false;
				StudentDao i=new StudentDao();
				inst=i.getStudent();
				for(Iterator it=inst.iterator();it.hasNext();) {
					Student c1=(Student) it.next();
					if(c1.getRequest()==0) {
						available=true;
						System.out.println("To Rasie the Request  set as Request Value=1 if not keep Request Value=0");
						System.out.println("Enter the Request value");
						value=sc.nextInt();
						res=StudentDao.raiseRequest(value, c1.getUser_id());
						if(res!=0) {
							
							System.out.println(" Request has been raised successfully");
						}
						else
						{
							System.out.println("Failled to Raise the Reques..! try again");
						}
					}
				}
				if(available==false)
				{
					System.out.println("Already request has been Raised");
				}
				
				break;
			case 3:
				List student=null;
				boolean Approved=false;
				student=StudentDao.getStudent();
				for(Iterator it=student.iterator();it.hasNext();)
				{
					Student c1=(Student) it.next();
					
					if(c1.getUser_id()==user_id && c1.getApproved()==1) {
						Approved=true;		
					}
				}
				if(Approved) {
					System.out.println("Status:");
					System.out.println("Your request approved by the Institute..! now your allowed to perform operations");
				}
				
				else {
					System.out.println("Status:");
					System.out.println("Not yet Approved by Institute...! Wait until approved by the Institute");
				}
				break;
			case 4:
				int result=0;
				System.out.println("Enter Complaint details");
				System.out.println("Enter the Complaint Id");
				int Complaint_ID=sc.nextInt();
				System.out.println("Enter the Institute name");
				String Institute_name=sc.next();
				System.out.println("Enter your complaint");
				sc.nextLine();
				String Complaint=sc.nextLine();
				Complaint ic=new Complaint(Complaint_ID,Institute_name,user_id,Complaint);
				result=StudentDao.insertComplaint(ic);
				if(result!=0) {
					System.out.println("Complaint raised to admin successful");
				}
				else {
					System.out.println("Failled to raise a complaint ..! Try again");
				}

				break;
			case 5:
				
				int result1=0;
				
				System.out.println("Give the Feedback");
				System.out.println("Enter the Faculty ID ");
				int id=sc.nextInt();
				System.out.println("Enter the Feedback");
				sc.nextLine();
				String feedback=sc.nextLine();
				Feedback feed=new Feedback(user_id,id,feedback);
				result1=StudentDao.InsertFeedback(feed);
				if(result1!=0) {
					System.out.println("Feedback given successful");
				}
				else {
					System.out.println("Failled to give Feedback ..! Try again");
				}
			}
			
			System.out.println("Do you wish to continue in Student Section(press any number not zero)");
			status=sc.nextInt();
		}while(!(status==0));
	}
	public static boolean Check_Approval(int id ) throws DBFWException,  StudentDaoException, DBConnectionException  {
		List student=null;
		boolean Approved=false;
		
		student=StudentDao.getStudent();
		for(Iterator it=student.iterator();it.hasNext();)
		{
			Student c1=(Student) it.next();
			
			if(c1.getUser_id()==id && c1.getApproved()==1) {
				Approved=true;		
			}
		}
		return Approved;
	
	}
	
	public static void main(String[] args) throws DBFWException, StudentDaoException, DBConnectionException {
		int choice;
		int status=0;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1. New Registration");
			System.out.println("2.Login");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1://inserting the new details 
				int result=0;
				System.out.println("Enter the Name");
				String Name=sc.next();
				System.out.println("Enter the Qualification");
				String Qualification=sc.next();
				System.out.println("Enter the password");
				String Password=sc.next();
				System.out.println("Enter the contact number");
				String Contact_number=sc.next();
				System.out.println("Enter the Address");
				String Address=sc.next();
				System.out.println("Enter email id");
				String Email_id=sc.next();
				System.out.println("Enter the User ID");
				int User_id=sc.nextInt();
				System.out.println("Enter the Institute Name");
				String Institute_name=sc.next();
				System.out.println("Enter the Approved status (o or 1) default is zero");
				int Approved=sc.nextInt();
				System.out.println("Enter the Request status (o or 1) ");
				int Request=sc.nextInt();
				Student s=new Student(Name,Qualification, Password, Contact_number, Address,Email_id, User_id, Institute_name, Approved,Request);
				
				result=StudentDao.InsertStudent(s);
				
				if(result!=0) {
					System.out.println("Registration successful");
					Student_Operation(User_id);
				}
				else {
					System.out.println("Registration failled..! Try again");
				}
			case 2:
				List student=null;
				boolean login=false;
				System.out.println("Enter the User ID");
				int id=sc.nextInt();
				System.out.println("Enter the Password");
				String pass=sc.next();
				
				
				student=StudentDao.getStudent();
				for(Iterator it=student.iterator();it.hasNext();)
				{
					Student c1=(Student) it.next();
					if(c1.getUser_id()==id && c1.getPassword().equals(pass)) {
						login=true;
					}	
					
				}
				if(login) {
					System.out.println("Login successful");
					Student_Operation(id);
				}
				else {
					System.out.println("Failed to login ..! try agian");
				}
				
			}
			System.out.println("Do you wish to continue in Student Section(press any number not zero) or Press 0 to exit");
			status=sc.nextInt();
		}while(!(status==0));
	}
}
