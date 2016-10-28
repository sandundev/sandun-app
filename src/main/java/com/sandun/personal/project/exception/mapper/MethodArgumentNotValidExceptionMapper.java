package com.sandun.personal.project.exception.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class MethodArgumentNotValidExceptionMapper  {

    public static Map<String, String> getMethodArgumentViolations(MethodArgumentNotValidException exception) {
	Map<String , String> errors = new HashMap<String , String>();
        for (FieldError err : exception.getBindingResult().getFieldErrors()) {
            errors.put(err.getField(), err.getDefaultMessage());
        }
	return errors;
    }
    
}
