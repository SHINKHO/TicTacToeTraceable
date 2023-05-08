package database.vo;

public class T3NotationVO {
	private String notationId;
	private String gameId;
	private String userId;
	private String locationId;
	public T3NotationVO(String notationId, String gameId, String userId, String locationId) {
		super();
		this.notationId = notationId;
		this.gameId = gameId;
		this.userId = userId;
		this.locationId = locationId;
	}
	public String getNotationId() {
		return notationId;
	}
	public void setNotationId(String notationId) {
		this.notationId = notationId;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "T3NotationVO [notationId=" + notationId + ", gameId=" + gameId + ", userId=" + userId + ", locationId="
				+ locationId + "]";
	}
	
	
}
