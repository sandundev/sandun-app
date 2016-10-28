package com.sandun.personal.project.service.authorisation;

import java.util.Set;

import org.springframework.stereotype.Service;


public interface AuthorisationService{

    Boolean isAllowedToCreate(String entityName, String username);

    Boolean isAllowedToUpdate(String entityName, String username);

    Set<String> getAuthorisedFieldsForRead(String entityName, String username);

    Boolean isAllowedToDelete(String entityName, String username);
 

}
