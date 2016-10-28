package com.sandun.personal.project.databind.converter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sandun.personal.project.databind.mapper.JacksonObjectDataMapper;

public class ObjectToMapConverter {

   public static Map<String, Object> getDataMap(Object object) throws IOException {
	ObjectMapper mapper = JacksonObjectDataMapper.getInstance();
	String json = mapper.writeValueAsString(object);
	Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
 
	return map;
    }

   public static Map<String, Object> getFilteredDataMap(Object object, Set<String> retainProperties) throws IOException {
	
	ObjectMapper mapper = JacksonObjectDataMapper.getInstance();
	FilterProvider filters = new SimpleFilterProvider().addFilter("fieldIncluder", SimpleBeanPropertyFilter.filterOutAllExcept(retainProperties));

	String json = mapper.writer(filters).writeValueAsString(object);
	Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});

	return map;
      }
}
