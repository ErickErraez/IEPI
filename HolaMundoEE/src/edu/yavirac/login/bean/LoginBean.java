package edu.yavirac.login.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {

	private String name;
	private String password;

	public LoginBean() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean auntenticacion() {
		return (password.equals("holaplatzi")) ? true : false;
	}

}
