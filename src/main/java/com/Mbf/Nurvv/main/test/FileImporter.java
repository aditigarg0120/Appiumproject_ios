package com.Mbf.Nurvv.main.test;

import com.Mbf.Nurvv.Utilities.FileUtils;
import com.Mbf.Nurvv.Utilities.User;
import com.Mbf.Nurvv.Utilities.Users;
import com.google.gson.Gson;

public class FileImporter {

	public static Users getUsers() {
		
		String json = FileUtils.readFile("/Users/mbf/Desktop/usersIos.json");
		
		Users users = new Gson().fromJson(json, Users.class);
		
		for(User user: users.getUsers()) {
			
			System.out.println("Feeding -> " + user);
			System.out.println("Doing test cases here..");
		}
		return users;
	}
	
	public static void main(String [] args) {
		FileImporter.getUsers();
	}
}
