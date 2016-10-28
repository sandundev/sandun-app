package com.sandun.personal.project.config.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.sandun.personal.project.model.security.AuthencatedUser;
import com.sandun.personal.project.service.authentication.AuthenticationService;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

  @Autowired
  private AuthenticationService authenticationService;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String authToken = httpRequest.getHeader("X-Authorization");
    
   AuthencatedUser user = authenticationService.authenticate(authToken);
    
    if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    
    chain.doFilter(request, response);
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
  
  
}
