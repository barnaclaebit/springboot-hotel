package com.barnaclaebit.project.entity.exception;

public class UserFoundException extends RuntimeException {
	

	    public UserFoundException() {
	        super("Already registered user");
	    }

	    public static String USER_FOUND = "Already registered user.";

}
