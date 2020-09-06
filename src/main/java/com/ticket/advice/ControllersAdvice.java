package com.ticket.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ticket.constants.ResponseConstants;
import com.ticket.exceptions.ValidationException;
import com.ticket.response.BaseResponse;

@RestControllerAdvice
public class ControllersAdvice {

	@ExceptionHandler(ValidationException.class)
	public BaseResponse validationException(ValidationException ex) {
		ex.printStackTrace();//TODO: use proper logging
		return BaseResponse.failure(ex.getResponseConstants());
	}

	@ExceptionHandler(Exception.class)
	public BaseResponse exception(Exception ex) {
		ex.printStackTrace(); //TODO: use proper logging
		return BaseResponse.failure(ResponseConstants.INTERNAL_SERVER_ERROR);
	}

}
