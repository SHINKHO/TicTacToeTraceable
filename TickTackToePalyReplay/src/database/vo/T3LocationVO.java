package database.vo;

public class T3LocationVO {
	private int xCoor;
	private int yCoor;
	private String locationId;
	public T3LocationVO(int xCoor, int yCoor, String locationId) {
		super();
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.locationId = locationId;
	}
	public int getxCoor() {
		return xCoor;
	}
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public int getyCoor() {
		return yCoor;
	}
	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	@Override
	public String toString() {
		return "T3LocationVO [xCoor=" + xCoor + ", yCoor=" + yCoor + ", locationId=" + locationId + "]";
	}
	
	
}
