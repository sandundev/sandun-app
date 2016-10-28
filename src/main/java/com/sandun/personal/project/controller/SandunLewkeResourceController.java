package com.sandun.personal.project.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.sandun.personal.project.databind.converter.JsonPatchObjectMapper;
import com.sandun.personal.project.databind.converter.ObjectToMapConverter;
import com.sandun.personal.project.exception.ApiError;
import com.sandun.personal.project.exception.SandunLewkeNotFoundException;
import com.sandun.personal.project.exception.mapper.ConstraintViolationExceptionMapper;
import com.sandun.personal.project.exception.mapper.MethodArgumentNotValidExceptionMapper;
import com.sandun.personal.project.model.core.SandunLewke;
import com.sandun.personal.project.model.security.AuthencatedUser;
import com.sandun.personal.project.repository.SandunLewkeRepository;
import com.sandun.personal.project.service.authorisation.AuthorisationService;

@RestController
public class SandunLewkeResourceController {

    private static final Logger LOGGER = Logger.getLogger(SandunLewkeResourceController.class);
    private static String RESOURCE_ENTITY_NAME = "client_profile";
    
    @Autowired
    private SandunLewkeRepository sandunLewkeRepository;
    
    @Autowired
    private AuthorisationService authorisationService;

    @PreAuthorize("@securityService.hasProtectedAccess()")
    @RequestMapping(value = "/sandun-lewke/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public  Map<String, Object> createNew(@RequestBody SandunLewke sandunLewke, HttpServletRequest request,  HttpServletResponse response) throws IOException {

	if(authorisationService.isAllowedToCreate(RESOURCE_ENTITY_NAME , getAuthencatedUsername())){
	    sandunLewke =sandunLewkeRepository.save(sandunLewke);
	    Set<String> allowedField = authorisationService.getAuthorisedFieldsForRead(RESOURCE_ENTITY_NAME,  getAuthencatedUsername());
	    Map<String, Object> dataMap = ObjectToMapConverter.getFilteredDataMap(sandunLewke, allowedField);
	    return dataMap;
	}	
	  response.setStatus(HttpStatus.FORBIDDEN.value());
	  return null;
    }
    
    @PreAuthorize("@securityService.hasProtectedAccess()")
    @RequestMapping(value = "/sandun-lewke/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getSandunLewke(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception{

	SandunLewke sandunLewke =sandunLewkeRepository.findOne(id);
	
	if (sandunLewke == null)
		throw new SandunLewkeNotFoundException(id);
	
	Set<String> allowedField = authorisationService.getAuthorisedFieldsForRead(RESOURCE_ENTITY_NAME , getAuthencatedUsername());
	Map<String, Object> dataMap = ObjectToMapConverter.getFilteredDataMap(sandunLewke, allowedField)  ;
	    
	return dataMap;
    }
    
    @PreAuthorize("@securityService.hasProtectedAccess()")
    @RequestMapping(value = "/sandun-lewke/{id}/update", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody @Valid SandunLewke sandunLewke, HttpServletRequest request, HttpServletResponse response) throws IOException {

	if (authorisationService.isAllowedToUpdate(RESOURCE_ENTITY_NAME , getAuthencatedUsername())) {
	    SandunLewke dbProfile =sandunLewkeRepository.findOne(id);

	    if (dbProfile == null) {
		throw new SandunLewkeNotFoundException(id);
	    }

	    SandunLewke mergedProfile = JsonPatchObjectMapper.getPatchedEntity(dbProfile, sandunLewke);
	   sandunLewkeRepository.save(mergedProfile);
	    return;
	}
	
	  response.setStatus(HttpStatus.FORBIDDEN.value());
    }
    
    @PreAuthorize("@securityService.hasProtectedAccess()")
    @RequestMapping(value = "/sandun-lewke/{id}/delete", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception{

	if (authorisationService.isAllowedToDelete(RESOURCE_ENTITY_NAME , getAuthencatedUsername())) {
	    
	    SandunLewke dbProfile =sandunLewkeRepository.findOne(id);
	    if (dbProfile == null) {
		throw new SandunLewkeNotFoundException(id);
	    }
	    dbProfile.setArchived(true);
	   sandunLewkeRepository.save(dbProfile);
	    return;
	}
	response.setStatus(HttpStatus.FORBIDDEN.value());
    }
    
    private String getAuthencatedUsername() {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	AuthencatedUser authUser = (AuthencatedUser) auth.getPrincipal() ;
	return authUser.getUsername();
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception, WebRequest request) {
	
	LOGGER.error(exception.getMessage());
	
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), ConstraintViolationExceptionMapper.getConstrainViolations(exception));
	return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentViolation(MethodArgumentNotValidException exception, WebRequest request) {
	 
	LOGGER.error(exception.getMessage());
	
	ApiError apiError =   new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), MethodArgumentNotValidExceptionMapper.getMethodArgumentViolations(exception));
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    } 
}
