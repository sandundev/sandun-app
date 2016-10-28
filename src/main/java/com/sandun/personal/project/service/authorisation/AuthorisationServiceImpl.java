package com.sandun.personal.project.service.authorisation;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class AuthorisationServiceImpl implements AuthorisationService{

    @Override
    public Boolean isAllowedToCreate(String entityName, String token) {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public Boolean isAllowedToUpdate(String entityName, String token) {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public Set<String> getAuthorisedFieldsForRead(String entityName, String token) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Boolean isAllowedToDelete(String entityName, String token) {
	// TODO Auto-generated method stub
	return true;
    }

}
