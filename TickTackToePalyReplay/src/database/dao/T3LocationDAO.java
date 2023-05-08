package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class T3LocationDAO {
	private T3LocationDAO() {}
	private static T3LocationDAO instance = new T3LocationDAO();
	public static T3LocationDAO getInstance() {
		return instance;
	}
	
	public ArrayList<Integer> getLocation(Connection conn,String locationId)throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append(" SELECT x_coor , y_coor ");
		query.append(" FROM t3_location ");
		query.append(" WHERE 1=1 ");
		query.append(" AND location_id = ? ");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, locationId);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Integer> resultAL = new ArrayList<>();
		while(rs.next()) {
			resultAL.add(rs.getInt(1));
			resultAL.add(rs.getInt(2));
		}
		
		return resultAL;
	}
	
	public int setLocation(Connection conn,int x,int y,String locationId)throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO t3_location ( ");
		query.append(" location_id, x_coor, y_coor ");
		query.append(" ) values ( ");
		query.append(" ? , ? , ? ");
		query.append(" ) ");
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, locationId);
		ps.setInt(2, x);
		ps.setInt(3, y);
		
		int result = ps.executeUpdate();
		return result;
	}
	
	public int deleteLocation(Connection conn,String locationId)throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append(" DELETE FROM t3_location ");
		query.append(" WHERE 1=1 ");
		query.append(" AND location_id = ? ");
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, locationId);
		
		int result = ps.executeUpdate();
		return result;
	}


	
}
