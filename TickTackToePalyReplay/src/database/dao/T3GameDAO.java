package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import database.vo.T3GameVO;

public class T3GameDAO {
	private T3GameDAO(){}
	private static T3GameDAO instance = new T3GameDAO();
	public static T3GameDAO getInstance() {
		return instance;
	}
	
	//insertion
	public int insertGame(Connection conn,Timestamp gameDate, String winner, String loser, String gameId) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO t3_game( ");
		query.append(" game_date, winner, loser, game_id " );
		query.append(" ) values ( ");
		query.append(" ? , ? , ? , ? ");
		query.append(" ) ");
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ps.setTimestamp(1,gameDate);
		ps.setString(2, winner);
		ps.setString(3, loser);
		ps.setString(4, gameId);
		
		int result = ps.executeUpdate();
		return result;
	}
	
	//search Options - list : winner, loser||  one Object return : gameId
	public ArrayList<T3GameVO> searchGameByWinner(Connection conn,String userId)throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT  game_date , winner , loser , game_id ");
		query.append(" FROM t3_game " );
		query.append(" where 1=1 ");
		query.append(" AND winner = ? " );
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<T3GameVO> resultList = new ArrayList<T3GameVO>();
		while(rs.next()) {
			Timestamp gameDate = rs.getTimestamp(1);
			String winner = rs.getString(2);
			String loser = rs.getString(3);
			String gameId = rs.getString(4);
			T3GameVO newGame = new T3GameVO(gameDate,winner,loser,gameId);
			resultList.add(newGame);
		}
		return resultList;
	}
	public ArrayList<T3GameVO> searchGameByLoser(Connection conn,String userId)throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT  game_date , winner , loser , game_id ");
		query.append(" FROM t3_game " );
		query.append(" where 1=1 ");
		query.append(" AND loser = ? " );
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<T3GameVO> resultList = new ArrayList<T3GameVO>();
		while(rs.next()) {
			Timestamp gameDate = rs.getTimestamp(1);
			String winner = rs.getString(2);
			String loser = rs.getString(3);
			String gameId = rs.getString(4);
			T3GameVO newGame = new T3GameVO(gameDate,winner,loser,gameId);
			resultList.add(newGame);
		}
		return resultList;
	}
	public T3GameVO searchGameByGameId(Connection conn,String gameId)throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT  game_date , winner , loser , game_id ");
		query.append(" FROM t3_game " );
		query.append(" where 1=1 ");
		query.append(" AND game_id = ? " );
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, gameId);
		ResultSet rs = ps.executeQuery();
		
		T3GameVO newGame = null;
		while(rs.next()) {
			Timestamp gameDate = rs.getTimestamp(1);
			String winner = rs.getString(2);
			String loser = rs.getString(3);
			String gId = rs.getString(4);
			newGame = new T3GameVO(gameDate,winner,loser,gId);
		}
		return newGame;
	}
	
}
