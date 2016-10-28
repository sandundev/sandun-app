package com.sandun.personal.project.databind.converter;

import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sandun.personal.project.databind.mapper.JacksonObjectDataMapper;

public class JsonPatchObjectMapper {

    public static <T> T getPatchedEntity(T dbEntity, Object reqObject) throws IOException {	
	
	ObjectMapper mapper = JacksonObjectDataMapper.getInstance();
	String json = mapper.writeValueAsString(reqObject);	
	return mapper.readerForUpdating(dbEntity).readValue(json);

    }

    public static <T> T getFilteredPatchedEntity(T dbEntity, Object reqObject , Set<String> retainProperties) throws IOException {

	ObjectMapper mapper = JacksonObjectDataMapper.getInstance();
	FilterProvider filters = new SimpleFilterProvider().addFilter("fieldIncluder", SimpleBeanPropertyFilter.filterOutAllExcept(retainProperties));
	String json = mapper.writer(filters).writeValueAsString(reqObject);
	
	return mapper.readerForUpdating(dbEntity).readValue(json);
    }
    
}
