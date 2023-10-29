package com.ntt.driver;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.ntt.dao.AdminDao;
import com.ntt.dao.InstituteDao;
import com.ntt.dao.InstituteDaoException;
import com.ntt.dao.StudentDao;
import com.ntt.dao.StudentDaoException;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.domain.Faculty;
import com.ntt.domain.Feedback;
import com.ntt.domain.Institute;

import com.ntt.domain.Student;

public class InstituteDriver {
	
	public static void Institute_Operations(String Name) throws DBFWException, InstituteDaoException, DBConnectionException, StudentDaoException {
		int ch;
		int status=0;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("INSTITUTE MENU");
			System.out.println("----------------------------");
			System.out.println("1.view student details");
			System.out.println("2.Add Faculty ");
			System.out.println("3.Update institute profile");
			System.out.println("4.View request");
			System.out.println("5.Send response to student request");
			System.out.println("6.View feedback");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				List studentview=null;
				StudentDao i2=new StudentDao();
				studentview=i2.getStudent();
				System.out.println("Student details are:");
				for(Iterator it=studentview.iterator();it.hasNext();) {
					Student c1=(Student) it.next();
					System.out.println(c1);
				}
				break;
			case 2:
				int result1=0;
				System.out.println("Enter Faculty data");
				System.out.println("Enter the Faculty Name");
				String fname=sc.next();
				System.out.println("Enter the Faculty Id");
				int fid=sc.nextInt();
				System.out.println("Enter the Faculty Subject");
				String sub=sc.next();
				//System.out.println("Enter the Institute Name");
				//String In_name=sc.next();
				Faculty fc=new Faculty(fname,fid,sub,Name);
				result1=InstituteDao.insertFaculty(fc);
				if(!(result1==0)) {
					System.out.println("Faculty added successfully");
				}
				else {
					System.out.println("Failled to add a faculty data ..! Try again");
				}
				break;
			case 3:
				List ilist=null;
				int result3=0;
				String Nname;	String Npass;	String Nadate;	String Nadd;	int Nseats;	int Ncourse;
			//	System.out.println("Enter the name of the institute to update profile");
				//String name=sc.next();
				ilist=InstituteDao.getInstitutes();
				for(Iterator it=ilist.iterator();it.hasNext();) {
					Institute c1=(Institute) it.next();
					if(c1.getInstitute_name().equals(Name)) {
						System.out.printf("Enter the New name for Institute..! if dont want to keep old name as %s %n",c1.getInstitute_name());
						Nname=sc.next();
						System.out.printf("Enter the New Password..! if dont want to keep old Password as %s %n",c1.getPassword());
						Npass=sc.next();
						System.out.printf("Enter the New Affiliation Date in the formate(dd-mm-yyyy)..! if dont want to keep old Affiliation Date as %s %n",c1.getAffiliation_Date());
						Nadate=sc.next();
						System.out.printf("Enter the New Address..! if dont want to keep old Address as %s %n",c1.getAddress());
						Nadd=sc.next();
						System.out.printf("Enter the New No of seats..! if dont want to keep old No of seats as %d %n",c1.getNumber_of_seats());
						Nseats=sc.nextInt();
						System.out.printf("Enter the New No of courses..! if dont want to keep old No of Courses as %d %n",c1.getNumber_of_course());
						Ncourse=sc.nextInt();
						result3=InstituteDao.updateInstitute(Nname, Npass, Nadate, Nadd, Nseats, Ncourse, c1.getInstitute_name());
						if(result3!=0) {
							
							System.out.println(Nname+"	Institute profile updated successfully");
						}
						else
						{
							System.out.println(c1.getInstitute_name()+"	Institute profile Not updated");
						}
					}
				}
				break;
			case 4:
				List studentreq=null;
				StudentDao i3=new StudentDao();
				studentreq=i3.getStudent();
				System.out.println("Student details are:");
				for(Iterator it=studentreq.iterator();it.hasNext();) {
					Student c1=(Student) it.next();
					if(c1.getRequest()==1) {
						System.out.println(c1);
					}
					
				}
				
				break;
				
			case 5:
				List inst=null;
				int res=0;
				int value=0;
				boolean available=false;
				StudentDao i=new StudentDao();
				inst=i.getStudent();
				for(Iterator it=inst.iterator();it.hasNext();)
				{
					Student c1=(Student) it.next();
					
					if(c1.getApproved()==0) {
						available=true;
						System.out.printf("To Approv the Student '%s' set Value=1 if not keep Value=0 %n",c1.getName());
						System.out.println("Enter the Approval value");
						value=sc.nextInt();
						res=InstituteDao.updateStudentApproval(value, c1.getUser_id());
						if(res!=0) {
							
							System.out.println(c1.getUser_id()+ " "+c1.getName()+ " Student Approved");
						}
						else
						{
							System.out.println(c1.getUser_id()+ " "+c1.getName()+"	Student Not Approved");
						}
					}	
				}
				if(available==false)
				{
					System.out.println("No Student Request available for Approval");
				}
				break;
				
			case 6:
				List feedback=null;
				InstituteDao i4=new InstituteDao();
				feedback=i4.getFeedback();
				System.out.println("Feedback are:");
				for(Iterator it=feedback.iterator();it.hasNext();) {
					Feedback c1=(Feedback) it.next();
					System.out.println(c1);
				}
			}
			System.out.println("Do you wish to continue in Institute Section(press any number not zero)");
			status=sc.nextInt();
			
		}while(!(status==0));
	}
	
	public static void Check_Approval(String Name ) throws DBFWException, InstituteDaoException, DBConnectionException, StudentDaoException {
		List inst=null;
		boolean Approved=false;
		InstituteDao i=new InstituteDao();
		inst=i.getInstitutes();
		for(Iterator it=inst.iterator();it.hasNext();)
		{
			Institute c1=(Institute) it.next();
			
			if(c1.getInstitute_name().equals(Name) && c1.getApproved()==1) {
				Approved=true;
			}
		}
		if(Approved) {
			Institute_Operations(Name);
		}
		else {
			System.out.println("Not yet Approved by Admin...! Wait Until your Institute Approved by the Admin");
		}
	}
	
	public static void main(String[] args) throws DBConnectionException, DBFWException, InstituteDaoException, StudentDaoException {
		int choice;
		int status=0;
		Scanner sc=new Scanner(System.in);
		do
		{
			
			System.out.println("1. New Registration");
			System.out.println("2.Login");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice) {
			case 1:// inserting new institute data
				int result=0;
				//enter the details
				System.out.println("Entet Institute name");
				String Institute_name=sc.next();
				System.out.println("Enter the password");
				String Password=sc.next();
				System.out.println("Enter the Affiliation Date in the formate(dd-mm-yyyy)");
				String Affiliation_Date=sc.next();
				System.out.println("Enter the Institute Address");
				String Address=sc.next();
				System.out.println("Enter the Total seats");
				int Number_of_seats=sc.nextInt();
				System.out.println("Enter the Number of course");
				int Number_of_course=sc.nextInt();
				System.out.println("Enter the approved status (defalut zero)");
				int Approved=sc.nextInt();
				
				Institute ir=new Institute(Institute_name,Password,
						Affiliation_Date,Address,Number_of_seats,Number_of_course,Approved);
				result=InstituteDao.insertInstitute(ir);
				if(result!=0) {
					System.out.println("Registration successful");
					
					Check_Approval(Institute_name);
				}
				else {
					System.out.println("Registration Failled ..! Try again");
				}
				break;
			case 2:
				List inst=null;
				boolean login=false;
				System.out.println("Enter the Institute Name");
				String name=sc.next();
				System.out.println("Enter the Password");
				String pass=sc.next();
				
				InstituteDao i=new InstituteDao();
				inst=i.getInstitutes();
				for(Iterator it=inst.iterator();it.hasNext();)
				{
					Institute c1=(Institute) it.next();
					
					if(c1.getInstitute_name().equals(name) && c1.getPassword().equals(pass)) {
						login=true;
						
						
					}
					
				}
				if(login) {
					System.out.println("Login successful");
					Check_Approval(name);
				}
				else {
					System.out.println("Failed to login ..! try agian");
				}
				
			}
			System.out.println("Do you wish to continue in Institute Home(press any number not zero)");
			status=sc.nextInt();
			
		}while(!(status==0));
	}

}
