package com.hsbc.entity;

public class User {
	private String name;
	private String role;
	private long telephone;
	private String email;
	private String userName;
	private String pwd;
	private String lastLogin;
	
	public User() {

	}

	public User(String name, String role, long telphone, String email, String userName, String pwd, String lastLogin) {
		this.name = name;
		this.role = role;
		this.telephone = telphone;
		this.email = email;
		this.userName = userName;
		this.pwd = pwd;
		this.lastLogin = lastLogin;
	}


	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setTelphone(long telphone) {
		this.telephone = telphone;
	}
	
	public long getTelphone() {
		return telephone;
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
	@Override
	public String toString() {
		return name + " " + telephone + " " + email + " " + userName + " " +lastLogin;
	}
}
