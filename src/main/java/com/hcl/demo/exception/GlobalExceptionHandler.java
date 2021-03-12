package com.hcl.demo.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for(ObjectError oe :ex.getBindingResult().getAllErrors()) {
			details.add(oe.getDefaultMessage());
		}
		ErrorResponse er = new ErrorResponse(400, details);
		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleOtherException(Exception c, WebRequest request){
		
		ErrorResponse er = new ErrorResponse(400, c.getCause());
		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(CustomException c, WebRequest request){
		
		ErrorResponse er = new ErrorResponse(c.getErrorCode(), c.getErrorMsg());
		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
	}
}
