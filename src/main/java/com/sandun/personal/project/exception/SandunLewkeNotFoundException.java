package com.sandun.personal.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SandunLewkeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SandunLewkeNotFoundException(Long clientId) {
		super("Profile not found for id: " + clientId);
	}
}
