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
import com.ntt.domain.Complaint;
import com.ntt.domain.Feedback;
import com.ntt.domain.Student;

public class StudentDao {
	static Logger log=Logger.getLogger(Student.class);
	
	public static int InsertStudent(final Student s) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper INSERTSTUDENT = new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1, s.getName());
					preStmt.setString(2,s.getQualification());
					preStmt.setString(3,s.getPassword());
					preStmt.setString(4,s.getContact_number());
					preStmt.setString(5,s.getAddress());
					preStmt.setString (6,s.getEmail_id());
					preStmt.setInt(7,s.getUser_id());
					preStmt.setString(8, s.getInstitute_name());
					preStmt.setInt(9, s.getApproved());
					preStmt.setInt(10, s.getRequest());
					
				}
				
			};
			result=DBHelper.executeUpdate(con, SQLMapper.REGISTERSTUDENT, INSERTSTUDENT);
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	public static List getStudent() throws DBFWException, StudentDaoException, DBConnectionException{
		
		List student=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			log.debug("fetching");

			student=DBHelper.executeSelect(con, SQLMapper.FETCHSTUDENTS, SQLMapper.STUDENTMAPPER);
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

		return student;
	}
	public static int updateStudent
	(String Nname,String NQualy,String Npass,String Ncont,String Nadd, String Nemail,int Nid, int id) throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper UPDATESTUDENT=new ParamMapper() {
	
				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1,Nname);
					preStmt.setString(2,NQualy);
					preStmt.setString(3,Npass);
					preStmt.setString(4,Ncont);
					preStmt.setString(5,Nadd);
					preStmt.setString(6,Nemail);
					preStmt.setInt(7, Nid);
					preStmt.setInt(8, id);
				}
			};
			result=DBHelper.executeUpdate(con, SQLMapper.UPDATESTUDENT,  UPDATESTUDENT);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static int raiseRequest(int value , int id) throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper UPDATEREQUEST=new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1, value);
					preStmt.setInt(2, id);
				}
			};
			result=DBHelper.executeUpdate(con, SQLMapper.RAISEREQUEST, UPDATEREQUEST);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static int insertComplaint(final Complaint Ic) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper COMPLAINTINSERT= new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1, Ic.getComplaint_ID());
					preStmt.setString(2, Ic.getInstitute_name());
					preStmt.setInt(3, Ic.getUser_id());
					preStmt.setString(4, Ic.getComplaint());
					
				
				}
				
			};
			result=DBHelper.executeUpdate(con, SQLMapper.INSERTCOMPLAINTS, COMPLAINTINSERT);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	public static int InsertFeedback(final Feedback f) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ch.getInstance();
			con=ch.getConnection();
			final ParamMapper FEEDBACKINSERT = new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1, f.getUser_id());
					preStmt.setInt(2, f.getId());
					preStmt.setString(3, f.getFeedback());
					
				}
				
			};
			result=DBHelper.executeUpdate(con, SQLMapper.INSERTFEEDBACK, FEEDBACKINSERT );
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
}
