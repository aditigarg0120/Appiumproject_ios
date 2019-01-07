package com.Mbf.Nurvv.Utilities;

public class User {

	private final String email;
	private final String fullName;
	private final String password;
	
	public User(String email, String fullName, String password) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", fullName=" + fullName + ", password=" + password + "]";
	}
}
