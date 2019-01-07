package com.Mbf.Nurvv.Utilities;

import java.util.ArrayList;
import java.util.List;

public class Users {

	private final List<User> users = new ArrayList<User>();
	
	public Users(List<User> users) {
		this.users.addAll(users);
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	@Override
	public String toString() {
		return users.toString();
	}
}
