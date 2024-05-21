package com.springboot.Exception;

import java.io.Serial;

public class EmployeeNotFountException extends RuntimeException{

	@Serial
	private static final long serialVersionUID = -8086417074928826643L;
	
	
	public EmployeeNotFountException(String message) {
		super(message);
	}

	

}
