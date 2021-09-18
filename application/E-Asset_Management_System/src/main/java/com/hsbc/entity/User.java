package com.hsbc.entity;

public class User {
	private int uId;
	private String name;
	private String role;
	private int telphone;
	private String email;
	private String userName;
	private String pwd;

	public User() {

	}

	public User(int uId, String name, String role, int telphone, String email, String userName, String pwd) {
		this.uId = uId;
		this.name = name;
		this.role = role;
		this.telphone = telphone;
		this.email = email;
		this.userName = userName;
		this.pwd = pwd;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTelphone() {
		return telphone;
	}

	public void setTelphone(int telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
