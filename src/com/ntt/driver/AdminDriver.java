package com.ntt.driver;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ntt.dao.AdminDao;
import com.ntt.dao.AdminDaoException;
import com.ntt.dao.InstituteDaoException;
import com.ntt.dao.StudentDao;
import com.ntt.dao.StudentDaoException;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.domain.Complaint;
import com.ntt.domain.Institute;
import com.ntt.domain.Student;

public class AdminDriver {
	public static String id;
	public static String password;
	
	public static boolean AdminAthentication() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Login using Admin credentials");
		System.out.println("Enter user id of admin");
		id=sc.next();
		System.out.println("Enter the Password of admin");
		password=sc.next();
		
		if(id.equals("Raju") && password.equals("Raju@7705")){
			return true;
			//System.out.println("login successful");
			
		}
		else {
			return false;
			//System.out.println("failled to login..! Try again");
		}
	}
	
	public static void main(String[] args) throws DBConnectionException, DBFWException, AdminDaoException, StudentDaoException {
		
		int ch;
		int status=0;
		Scanner sc= new Scanner(System.in);
		boolean validate=AdminAthentication();
		if(validate) {
			do {
				int choice;
				System.out.println("ADMIN MENU");
				System.out.println("--------------------------------------");
				System.out.println("1.Approve the institute");
				System.out.println("2.Delete Institute");
				System.out.println("3.View Student");
				System.out.println("4.View Complaint");
				System.out.println("Enter your choice");
				choice=sc.nextInt();
				switch(choice) {
				case 1:
					List ilist=null;
					int res=0;
					int value=0;
					boolean available=false;
					ilist=AdminDao.getInstitutes();
					for(Iterator it=ilist.iterator();it.hasNext();)
					{
						Institute c1=(Institute) it.next();
						//System.out.println(c1);
						
						if(c1.getApproved()==0) {
							available=true;
							System.out.printf("To Approv the Institute %s set Value=1 if not keep Value=0 %n",c1.getInstitute_name());
							System.out.println("Enter the Approval value");
							value=sc.nextInt();
							res=AdminDao.updateInstituteApproval(value, c1.getInstitute_name());
							if(res!=0) {
								
								System.out.println(c1.getInstitute_name()+"	Institute Approved");
							}
							else
							{
								System.out.println(c1.getInstitute_name()+"	Institute Not Approved");
							}
						}	
					}
					if(available==false)
					{
						System.out.println("No Institute Request available for Approval");
					}
					break;
				case 2:
					List ilist1=null;
					int res1=0;
					boolean exist=false;
					System.out.println("Enter the Institute Name you to  delete");
					String name=sc.next();
					ilist1=AdminDao.getInstitutes();
					for(Iterator it=ilist1.iterator();it.hasNext();) {
						Institute c1=(Institute) it.next();
						if(c1.getInstitute_name().equals(name)) {
							exist=true;	
						}
						
					}
					if(exist) {
						res1=AdminDao.deleteInstitute(name);
					}
					else {
						System.out.println("Entered Institute name does not exit in the database");
					}
					if(!(res1==0)) {
						System.out.println(name+" Institute deleted successfully");
					}
					else {
						System.out.println("Failed to delete Institute "+name);
					}
					break;
					
				case 3:
					List student=null;
					StudentDao s1=new StudentDao();
					student=s1.getStudent();
					for(Iterator it=student.iterator();it.hasNext();) {
						Student c1=(Student) it.next();
						System.out.println(c1);
						
					}
					break;
				case 4:
					List complaints=null;
					complaints=AdminDao.getComplaints();
					System.out.println("Complaints are:");
					for(Iterator it=complaints.iterator();it.hasNext();) {
						Complaint c1=(Complaint) it.next();
						System.out.println(c1);		
					}
				}
				
				System.out.println("Do you wish to continue in Admin Menu(press any number not zero)");
				status=sc.nextInt();
				
			}while(!(status==0));
		}
		else {
			System.out.println("failled to login..! Try again");
		}
	}
	
}

