package database.vo;

public class T3UserVO {
	private String userId;
	private String userName;
	public T3UserVO(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "T3UserVO [userId=" + userId + ", userName=" + userName + "]";
	}
	
}
