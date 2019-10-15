package com.springmvc.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	USER("User"),
	DBA("DBA"),
	ADMIN("Admin");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
	public String getUserProfileType() {
		return userProfileType;
	}

	public void setUserProfileType(String userProfileType) {
		this.userProfileType = userProfileType;
	}
	
}
