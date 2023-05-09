package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.vo.T3NotationVO;

public class T3NotationDAO {
	private T3NotationDAO() {}
	private static T3NotationDAO instance = new T3NotationDAO();
	public static T3NotationDAO getInstance() {
		return instance;
	}
	
	
	//insertion
	public int insertNotation(Connection conn,String notationId , String gameId, String userId, String locationId)throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO t3_notation ( ");
		query.append(" notation_id, game_id, user_id, location_id ");
		query.append(" ) values ( ");
		query.append(" ?, ?, ?, ? ");
		query.append(" ) ");
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ps.setString(1, notationId);
		ps.setString(2, gameId);
		ps.setString(3, userId);
		ps.setString(4, locationId);
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	
	
	//getting options 
	public ArrayList<T3NotationVO> getNotationsByGame(Connection conn,String gameId) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT notation_id, game_id, user_id, location_id ");
		query.append(" FROM t3_notation " );
		query.append(" WHERE 1=1 ");
		query.append(" AND game_id = ? " );
		query.append(" ORDER BY notation_id " );
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, gameId);
		ResultSet rs = ps.executeQuery();
		ArrayList<T3NotationVO> resultList= new ArrayList<T3NotationVO>();
		while(rs.next()) {
			String nId = rs.getString(1);
			String gId = rs.getString(2);
			String uId = rs.getString(3);
			String lId = rs.getString(4);
			T3NotationVO newNotation = new T3NotationVO(nId,gId,uId,lId);
			resultList.add(newNotation);
		}
		return resultList;
	}
	
	public ArrayList<T3NotationVO> getNotationsByGameAndUser(Connection conn ,String gameId, String userId)throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append(" SELECT notation_id, game_id, user_id, location_id ");
		query.append(" FROM t3_notation " );
		query.append(" WHERE 1=1 ");
		query.append(" AND game_id = ? " );
		query.append(" AND user_id = ? ");
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, gameId);
		ps.setString(2, userId);
		ResultSet rs = ps.executeQuery();
		ArrayList<T3NotationVO> resultList= new ArrayList<T3NotationVO>();
		while(rs.next()) {
			String nId = rs.getString(1);
			String gId = rs.getString(2);
			String uId = rs.getString(3);
			String lId = rs.getString(4);
			T3NotationVO newNotation = new T3NotationVO(nId,gId,uId,lId);
			resultList.add(newNotation);
		}
		return resultList;
	}
}
