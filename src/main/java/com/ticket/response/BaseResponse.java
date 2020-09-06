package com.ticket.response;

import org.springframework.http.HttpStatus;

import com.ticket.constants.ResponseConstants;

public class BaseResponse {

	private String status;
	private String code;
	private String message;
	private Object data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static BaseResponse success() {
		BaseResponse response = new BaseResponse();
		response.setStatus(ResponseConstants.SUCCESS);
		response.setMessage(ResponseConstants.SUCCESS_MESAGE);
		response.setCode(HttpStatus.OK.value() + "");// for later use to return more discrete response codes
		return response;
	}

	public static BaseResponse success(Object data) {
		BaseResponse response = success();
		response.setData(data);
		return response;
	}

	public static BaseResponse failure(String responseConstants) {
		BaseResponse response = new BaseResponse();
		response.setStatus(ResponseConstants.FAILURE);
		response.setMessage(ResponseConstants.FAILURE_MESAGE);
		response.setCode(responseConstants);// for later use to return more discrete response codes
		return response;
	}

}
