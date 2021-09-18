package com.hsbc.entity;

public class User {
	private String name;
	private String role;
	private long telphone;
	private String email;
	private String userName;
	private String pwd;

	public User() {

	}

	public User(String name, String role, long telphone, String email, String userName, String pwd) {
		this.name = name;
		this.role = role;
		this.telphone = telphone;
		this.email = email;
		this.userName = userName;
		this.pwd = pwd;
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

	public long getTelphone() {
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
