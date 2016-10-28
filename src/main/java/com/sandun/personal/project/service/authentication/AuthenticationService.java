package com.sandun.personal.project.service.authentication;

import com.sandun.personal.project.exception.UnauthorisedAccessException;
import com.sandun.personal.project.model.security.AuthencatedUser;

public interface AuthenticationService {

    public AuthencatedUser authenticate(String authToken) throws UnauthorisedAccessException;

}
