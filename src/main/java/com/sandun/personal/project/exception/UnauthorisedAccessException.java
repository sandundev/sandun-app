package com.sandun.personal.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorisedAccessException extends RuntimeException {

    private static final long serialVersionUID = 43242432423423L;

    public UnauthorisedAccessException(String message) {
	super(message);
    }
}
