package valueObject;

public class VUser {
	private String userId;
	private String userName;
	
	public VUser(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}
	public String getName() {
		return userName;
	}
}
