package com.sandun.personal.project.service.authentication;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import com.sandun.personal.project.exception.ApiError;
import com.sandun.personal.project.exception.UnauthorisedAccessException;
import com.sandun.personal.project.model.security.AuthencatedUser;
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private static final Logger LOGGER = Logger.getLogger(AuthenticationServiceImpl.class);
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${authentication.server.base.url}")
    public String serviceUrl;

    @Override
    public AuthencatedUser authenticate(String authToken) throws UnauthorisedAccessException {

	HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

	try {
	    ResponseEntity<AuthencatedUser> authUser = restTemplate.postForEntity(serviceUrl + "/token/validate"  , new HttpEntity<Token>(new Token(authToken), headers), AuthencatedUser.class);
		if(HttpStatus.UNAUTHORIZED.equals(authUser.getStatusCode())){
		    throw new UnauthorisedAccessException("you are not authenticated to use this service!!");
		}
		
		return authUser.getBody();
	} catch (Exception e) {
	    e.printStackTrace(); // TODO: this try catch block need changing./.......
	}
	return null;
    }
    
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleUnAuthorisedAccess(HttpClientErrorException exception, WebRequest request) {
	
	LOGGER.error(exception.getMessage());
	
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), null);
	return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
    
    public static class Token {
	protected String token;

	public Token(String authToken) {
	 this.token = authToken;
	}

	public String getToken() {
	    return token;
	}

	public void setToken(String token) {
	    this.token = token;
	}
    }
}
