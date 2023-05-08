package database.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import database.context.ConnectionPool;
import database.dao.T3GameDAO;
import database.vo.T3GameVO;

public class T3GameService {
	private T3GameService() {}
	private static T3GameService instance = new T3GameService();
	private ConnectionPool cp = ConnectionPool.getInstance();
	private T3GameDAO dao = T3GameDAO.getInstance();
	public static T3GameService getInstance() {
		return instance;
	}

	public int insertGame(Timestamp gameDate, String winner, String loser, String gameId) {
		Connection conn = cp.getConnection();
		int result = -1;
		try {
			result = dao.insertGame(conn, gameDate, winner, loser, gameId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);	
		}
		return result;
	}

	public ArrayList<T3GameVO> searchGameByWinner(String userId){
		Connection conn = cp.getConnection();
		ArrayList<T3GameVO> result = new ArrayList<T3GameVO>();
		try {
			result = dao.searchGameByWinner(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);	
		}
		return result;
	}

	public ArrayList<T3GameVO> searchGameByLoser(String userId){
		Connection conn = cp.getConnection();
		ArrayList<T3GameVO> result = new ArrayList<T3GameVO>();
		try {
			result = dao.searchGameByLoser(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);	
		}
		return result;
	}

	public T3GameVO searchGameByGameId(String gameId) {
		Connection conn = cp.getConnection();
		T3GameVO result = null;
		try {
			result = dao.searchGameByGameId(conn, gameId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);	
		}
		return result;
	}

}
