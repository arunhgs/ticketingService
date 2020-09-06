package com.ticket.exceptions;

public class ValidationException extends RuntimeException {

	private String responseConstants;

	private static final long serialVersionUID = 1L;

	public ValidationException(String responseConstants) {
		this.responseConstants = responseConstants;
	}

	public String getResponseConstants() {
		return responseConstants;
	}

	public void setResponseConstants(String responseConstants) {
		this.responseConstants = responseConstants;
	}

}
