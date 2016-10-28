package com.sandun.personal.project.config;

import java.util.logging.Logger;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.HttpPutFormContentFilter;

import com.sandun.personal.project.ApplicationServer;

/**
 * 
 * To execute as a microservice, run {@link ApplicationServer} instead.
 * 
 * @author Sandun Lewke
 */
@SpringBootApplication
@EntityScan("com.sandun.personal.project.model")
@EnableJpaRepositories("com.sandun.personal.project.repository")
@PropertySource("classpath:application.properties")
@ComponentScan("com.sandun.personal.project")
public class SandunLewkeApplication extends SpringBootServletInitializer {

    protected Logger logger = Logger.getLogger(SandunLewkeApplication.class.getName());

    @Bean
    public RestTemplate restTemplate() {
	    HttpClient httpClient = HttpClients.createDefault();
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient)); 
 
	return restTemplate;
    }
    
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
         return new MethodValidationPostProcessor();
    }

}
