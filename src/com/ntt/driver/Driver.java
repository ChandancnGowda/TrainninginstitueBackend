 package com.ntt.driver;

import java.util.Scanner;

import com.ntt.dao.AdminDaoException;
import com.ntt.dao.InstituteDaoException;
import com.ntt.dao.StudentDaoException;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;

public class Driver  {
	public static void main(String[] args) throws DBConnectionException, DBFWException, InstituteDaoException,
	AdminDaoException, StudentDaoException {
		
		int choice;
		int status=0;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("-------------ROLES-------------");
			System.out.println("1.Admin");`
			System.out.println("2.Institute");
			System.out.println("3.Student");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice) {
			
			case 1:System.out.println("Admin Section");
				AdminDriver.main(args);
				break;
			case 2:System.out.println("Institute Section");
				
				InstituteDriver.main(args);
				break;
			case 3:System.out.println("Student Section");
				StudentDriver.main(args);
			
			}
			System.out.println("Welcome back to Home Roles menu");
			System.out.println("Do you wish to continue(press any number not zero)");
			status=sc.nextInt();
			
		}while(!(status==0));
	}

}
