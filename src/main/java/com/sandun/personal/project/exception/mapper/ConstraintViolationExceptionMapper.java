package com.sandun.personal.project.exception.mapper;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class ConstraintViolationExceptionMapper  {

    public static Map<String, String> getConstrainViolations(ConstraintViolationException ex) {
	Map<String , String> errors = new HashMap<String , String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.put(violation.getPropertyPath().toString() , violation.getPropertyPath().toString() +" "+ violation.getMessage());
        }
	return errors;
    }
}
