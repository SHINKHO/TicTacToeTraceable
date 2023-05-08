package database.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import database.context.ConnectionPool;
import database.dao.T3NotationDAO;
import database.vo.T3NotationVO;

public class T3NotationService {
	private ConnectionPool cp = ConnectionPool.getInstance();
	private T3NotationDAO dao = T3NotationDAO.getInstance();
	private T3NotationService() {}
	private static T3NotationService instance = new T3NotationService();

	public static T3NotationService getInstance() {
		return instance;
	}
	
	//insertion
	public int insertNotation(String notationId , String gameId, String userId, String locationId){
		Connection conn = cp.getConnection();
		int result = -1;
		try {
			result =dao.insertNotation(conn, notationId, gameId, userId, locationId);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	
	
	//getting options 
	public ArrayList<T3NotationVO> getNotationsByGame(String gameId){
		Connection conn = cp.getConnection();
		ArrayList<T3NotationVO> result = new ArrayList<>();
		try {
			result = dao.getNotationsByGame(conn, gameId);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result ;
	}
	
	public ArrayList<T3NotationVO> getNotationsByGameAndUser(String gameId, String userId){
		Connection conn = cp.getConnection();
		ArrayList<T3NotationVO> result = new ArrayList<T3NotationVO>();
		try {
			result = dao.getNotationsByGameAndUser(conn, gameId, userId);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
}
