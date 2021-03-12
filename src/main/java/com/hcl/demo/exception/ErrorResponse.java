package com.hcl.demo.exception;

public class ErrorResponse {

	private Integer errorCode;
	private Object errorMsg;
	public ErrorResponse(Integer errorCode, Object errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public Object getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(Object errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
