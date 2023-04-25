package com.example.demo.response;

public class UserRest {
	
	private String userFirstName;
	private String userLastName;
	private String userid;
	public UserRest(String userFirstName, String userLastName, String userid) {
		
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userid = userid;
	}

	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
