package database.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import database.context.ConnectionPool;
import database.dao.T3LocationDAO;

public class T3LocationService {
	private T3LocationDAO dao = T3LocationDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	private T3LocationService() {}
	private static T3LocationService instance = new T3LocationService(); 

	public static T3LocationService getInstance() {
		return instance;
	}
	
	public ArrayList<Integer> getLocation(String locationId){
		Connection conn = cp.getConnection();
		ArrayList<Integer> result = new ArrayList<Integer>();
		try {
			result =dao.getLocation(conn, locationId);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	public int setLocation(int x,int y,String locationId){
		Connection conn = cp.getConnection();
		int result = -1;
		try {
			result =dao.setLocation(conn, x, y, locationId);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	public int deleteLocation(String locationId){
		Connection conn = cp.getConnection();
		int result = -1;
		try {
			result =dao.deleteLocation(conn, locationId);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	public int resetLocation() {
		Connection conn =cp.getConnection();
		int result= -1;
		try {
			result =dao.resetLocation(conn);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
}
