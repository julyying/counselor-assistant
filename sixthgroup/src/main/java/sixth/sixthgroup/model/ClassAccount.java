package sixth.sixthgroup.model;

public class ClassAccount {
	
	private Integer userId;
	 
	private String gradName;
	
	private Integer gradId;
	
	private String userName;

	private String userPassword;

	public String getGradName() {
		return gradName;
	}

	public Integer getGradId() {
		return gradId;
	}

	public void setGradId(Integer gradId) {
		this.gradId = gradId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setGradName(String gradName) {
		this.gradName = gradName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
