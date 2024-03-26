package com.barnaclaebit.project.entity.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException() {
        super("User not founded.");
    }

    public static String USER_NOT_FOUNDED = "User not founded.";

}
