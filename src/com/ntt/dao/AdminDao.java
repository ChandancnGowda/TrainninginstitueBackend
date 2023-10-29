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

public class AdminDao {
	static Logger log=Logger.getLogger(AdminDao.class);
	
	public static List getInstitutes() throws DBFWException,AdminDaoException, DBConnectionException {
		List institutes=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
		ch=ch.getInstance();
		con=ch.getConnection();
		log.debug("fetching");
		
		institutes=DBHelper.executeSelect(con, SQLMapper.FETCHINSTITUTES, SQLMapper.INSTITUTEMAPPER);
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
		return institutes;
		
	}
	public static int updateInstituteApproval(int value , String name) throws DBFWException {
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
					preStmt.setString(2, name);
				}
			};
			result=DBHelper.executeUpdate(con, SQLMapper.UPDATEINSTITUTEAPPROVAL, UPDATEAPPROVAL);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static int deleteInstitute(String name) throws DBFWException {
		
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ch.getInstance();
			con=ch.getConnection();	
			final ParamMapper INSTITUTEDELETE=new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setString(1, name);
					
				}
			};
			result=DBHelper.executeUpdate(con, SQLMapper.DELETEINSTITUTE, INSTITUTEDELETE);
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	public static List getComplaints() throws DBFWException,AdminDaoException, DBConnectionException {
		List complaints=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
		ch=ch.getInstance();
		con=ch.getConnection();
		log.debug("fetching");
		
		complaints=DBHelper.executeSelect(con, SQLMapper.FETCHCOMPLAINTS, SQLMapper.COMPLAINTMAPPER);
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
		return complaints;
		
	}
}
