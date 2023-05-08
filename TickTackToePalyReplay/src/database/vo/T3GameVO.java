package database.vo;

import java.sql.Timestamp;

public class T3GameVO {
	private Timestamp gameDate;
	private String winner;
	private String looser;
	private String gameId;
	public T3GameVO(Timestamp gameDate, String winner, String looser, String gameId) {
		super();
		this.gameDate = gameDate;
		this.winner = winner;
		this.looser = looser;
		this.gameId = gameId;
	}
	public Timestamp getGameDate() {
		return gameDate;
	}
	public void setGameDate(Timestamp gameDate) {
		this.gameDate = gameDate;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getLooser() {
		return looser;
	}
	public void setLooser(String looser) {
		this.looser = looser;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	@Override
	public String toString() {
		return "T3GameVO [gameDate=" + gameDate + ", winner=" + winner + ", looser=" + looser + ", gameId=" + gameId
				+ "]";
	}
	
	
}
