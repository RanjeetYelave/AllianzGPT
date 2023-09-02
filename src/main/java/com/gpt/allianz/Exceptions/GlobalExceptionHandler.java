package com.gpt.allianz.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundEx.class)
	ResponseEntity<ResponseHandler> ResourceNotFoundExceptionHandler(NotFoundEx ex) {
		String message = ex.getMessage();

		return new ResponseEntity<ResponseHandler>(new ResponseHandler(message, false), HttpStatus.NOT_FOUND);
	}
}