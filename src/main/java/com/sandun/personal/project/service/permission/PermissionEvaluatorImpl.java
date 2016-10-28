package com.sandun.personal.project.service.permission;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("permissionEvaluator")
public class PermissionEvaluatorImpl implements PermissionEvaluator{
//
//    @Autowired
//    RestTemplate restTemplate;
    
    @Override
    public boolean hasPermission(Authentication arg0, Object arg1, Object arg2) {
	// TODO Auto-generated method stub
	 
	System.out.println("true 1");
	return false;
    }

    @Override
    public boolean hasPermission(Authentication arg0, Serializable arg1, String arg2, Object arg3) {
	// TODO Auto-generated method stub
	System.out.println("true 2");
	return false;
    }
    
    public boolean isAuthorized(HttpServletRequest request)
    {
	String authorizationHeader = request.getHeader("X-Authorization");
	System.out.println(authorizationHeader);
	return authorizationHeader != null && authorizationHeader.length() > 5; // TODO
    }
}
