package com.devfun.setting_boot.exception;

public class ErrorMessage {
	private String errorCode;
	private String errorMessage;
	
	public ErrorMessage(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getCode() {
		return errorCode;
	}
	public void setCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return errorMessage;
	}
	public void setMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
