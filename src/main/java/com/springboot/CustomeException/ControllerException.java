package com.springboot.CustomeException;

public class ControllerException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorStatus;
	public ControllerException() {
		
	}
	public ControllerException(String errorCode, String errorStatus) {
		super();
		this.errorCode = errorCode;
		this.errorStatus = errorStatus;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}
	
	

}
