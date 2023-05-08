package database.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import database.context.ConnectionPool;
import database.dao.T3UserDAO;

public class T3UserService {

	
	private T3UserService() {}
	private static T3UserService instance = new T3UserService();
	private T3UserDAO dao = T3UserDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	public static T3UserService getInstance() {
		return instance;
	}
	
	public int addUser(String userId,String userName){
		Connection conn = cp.getConnection();
		int result = -1;
		try {
			result = dao.addUser(conn, userId, userName);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	public String getUserName(String userId){
		Connection conn = cp.getConnection();
		String result= null;
		try {
			result=dao.getUserName(conn, userId);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	public String getUserId(String userName){
		Connection conn = cp.getConnection();
		String result= null;
		try {
			result=dao.getUserId(conn, userName);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}

	
	public HashMap<String,String> getUsers(){
		Connection conn = cp.getConnection();
		HashMap<String,String> result = new HashMap<String,String>();
		try {
			result= dao.getUsers(conn);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	public int deleteUser(String userId){
		Connection conn = cp.getConnection();
		int result = -1;
		try {
			result = dao.deleteUser(conn, userId);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
}
