package com.ntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ntt.dbcon.ConnectionHolder;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.dbfw.DBHelper;
import com.ntt.dbfw.ParamMapper;
import com.ntt.domain.Faculty;
import com.ntt.domain.Institute;

import com.ntt.domain.Institute;


public class InstituteDao {
	static Logger log=Logger.getLogger(InstituteDao.class);
	
	public static int insertInstitute(final Institute Ir) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper INSTITUTEINSERT= new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1, Ir.getInstitute_name());
					preStmt.setString(2, Ir.getPassword());
					preStmt.setString(3, Ir.getAffiliation_Date());
					preStmt.setString(4, Ir.getAddress());
					preStmt.setInt(5, Ir.getNumber_of_seats());
					preStmt.setInt(6, Ir.getNumber_of_course());
					preStmt.setInt(7, Ir.getApproved());
					
					
				}
				
			};
			result=DBHelper.executeUpdate(con, SQLMapper.REGISTERINSTITUTE, INSTITUTEINSERT);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	public static List getInstitutes() throws DBFWException,InstituteDaoException, DBConnectionException{
		
		List institute=null;
		ConnectionHolder ch=null;
		Connection con=null;
	
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			log.debug("fetching");

			institute=DBHelper.executeSelect(con, SQLMapper.FETCHINSTITUTES, SQLMapper.INSTITUTEMAPPER);
		}
		catch (DBConnectionException e){
			throw new DBConnectionException("Unable to connect to db"+e);
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}

		return institute;
	}
	public static int updateStudentApproval(int value , int id) throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper UPDATEAPPROVAL=new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1, value);
					preStmt.setInt(2, id);
				}
			};
			result=DBHelper.executeUpdate(con, SQLMapper.UPDATESTUDENTAPPROVAL, UPDATEAPPROVAL);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static int insertFaculty(final Faculty If) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper FACULTYINSERT= new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1,If.getName());
					preStmt.setInt(2, If.getId());
					preStmt.setString(3, If.getSubject());
					preStmt.setString(4, If.getInstitute_name());
					
				
				}
				
			};
			result=DBHelper.executeUpdate(con, SQLMapper.INSERTFACULTY, FACULTYINSERT);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	public static int updateInstitute
	(String Nname,String Npass,String Nadate,String Nadd,int Nseats,int Ncourse, String name) throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper UPDATEINSTITUTE=new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1,Nname);
					preStmt.setString(2,Npass);
					preStmt.setString(3,Nadate);
					preStmt.setString(4,Nadd);
					preStmt.setInt(5,Nseats);
					preStmt.setInt(6,Ncourse);
					preStmt.setString(7, name);
				}
			};
			result=DBHelper.executeUpdate(con, SQLMapper.UPDATEINSTITUTE,  UPDATEINSTITUTE);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static List getFeedback() throws DBFWException,InstituteDaoException, DBConnectionException{
		
		List feed=null;
		ConnectionHolder ch=null;
		Connection con=null;
	
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			log.debug("fetching");

			feed=DBHelper.executeSelect(con, SQLMapper.FETCHFEEDBACK, SQLMapper.FEEDBACKMAPPER);
		}
		catch (DBConnectionException e){
			throw new DBConnectionException("Unable to connect to db"+e);
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}

		return feed;
	}

}
