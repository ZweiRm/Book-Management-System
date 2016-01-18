package cn.bean;

public class User extends ValueObject {

	private String USER_NAME;
	private String USER_PASSWORD;

	public User() {
	}

	public User(String id, String user_name, String user_password) {
		setID(id);
		USER_NAME = user_name;
		USER_PASSWORD = user_password;
	}

	public void setUSER_NAME(String user_name) {
		USER_NAME = user_name;

	}

	public void setUSER_PASSWORD(String user_password) {
		USER_PASSWORD = user_password;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
}
