package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class T3UserDAO {
	private T3UserDAO() {}
	private static  T3UserDAO instance = new T3UserDAO();
	public static T3UserDAO getInstance() {
		return instance;
	}
	
	
	public int addUser(Connection conn, String userId,String userName)throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO t3_user( ");
		query.append(" user_id, user_name ");
		query.append(" ) values ( ");
		query.append(" ? , ? ");
		query.append(" ) ");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, userId);
		ps.setString(2, userName);
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	public String getUserName(Connection conn, String userId)throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append(" SELECT user_name ");
		query.append(" FROM t3_user ");
		query.append(" WHERE 1=1 ");
		query.append(" AND user_id = ? ");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1,userId);
		
		ResultSet rs = ps.executeQuery();
		
		String result=null;
		while(rs.next()) {
			result = rs.getString(1);
		}
		
		return result;
	}
	
	public String getUserId(Connection conn, String userName)throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append(" SELECT user_id ");
		query.append(" FROM t3_user ");
		query.append(" WHERE 1=1 ");
		query.append(" AND user_name = ? ");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1,userName);
		
		ResultSet rs = ps.executeQuery();
		
		String result=null;
		while(rs.next()) {
			result = rs.getString(1);
		}
		
		return result;
	}
	
	public HashMap<String,String> getUsers(Connection conn)throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append(" SELECT user_id,user_name ");
		query.append(" FROM t3_user ");
		query.append(" WHERE 1=1 ");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ResultSet rs = ps.executeQuery();
		
		HashMap<String,String> result= new HashMap<String,String>();
		while(rs.next()) {
			result.put(rs.getString(1), rs.getString(2));
		}
		
		return result;
	}
	
	public int deleteUser(Connection conn,String userId)throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append(" DELETE FROM t3_user ");
		query.append(" WHERE 1=1 ");
		query.append(" AND ");
		query.append(" user_id = ? ");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, userId);
		
		int result = ps.executeUpdate();
		
		return result;
	}

}
