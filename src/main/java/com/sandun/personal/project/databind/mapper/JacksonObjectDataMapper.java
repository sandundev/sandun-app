package com.sandun.personal.project.databind.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonObjectDataMapper {

    static volatile ObjectMapper objectMapper = null;

    private JacksonObjectDataMapper() {
    }

    public static ObjectMapper getInstance() {
	if (objectMapper == null) {
	    synchronized (ObjectMapper.class) {
		if (objectMapper == null) {
		    objectMapper = new ObjectMapper();
		    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		    objectMapper.setDateFormat(df);
		}
	    }
	}
	return objectMapper;
    }
}
