package com.cg.mtb.entities;

import com.cg.mtb.entities.User;

public class SignIn extends User{

	private boolean loginStatus;
	private User user;

	public SignIn() {

	}

	public SignIn(boolean loginStatus, User user) {
		super();
		this.loginStatus = loginStatus;
		this.user = user;
	}

	public boolean isActive() {
		return loginStatus;
	}

	public void setIsActive(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return user.getRole();
	}

	
}
