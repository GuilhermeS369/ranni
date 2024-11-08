package com.ranni.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ranni.services.exceptions.DatabaseException;
import com.ranni.services.exceptions.ResourceNotFoundException;

// INTERCEPTA AS EXCEÇÕES QUE ACONTECEREM PARA QUE
// ESSE OBJETO POSSA FAZER UM TRATAMENTO
@ControllerAdvice
public class ResourceExceptionHandler {
	
	//ANOTAÇÃO PARA INTERCEPTAR A REQUISIÇÃO QUE DEU EXCEÇÃO
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		// TRATAMENTO
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		
		// TRATAMENTO
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
