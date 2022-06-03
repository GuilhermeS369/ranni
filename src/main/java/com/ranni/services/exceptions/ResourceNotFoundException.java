package com.ranni.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	// RECEBE O OBJ QUE TENTOU ACHAR E N ENCONTROU
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}

}
