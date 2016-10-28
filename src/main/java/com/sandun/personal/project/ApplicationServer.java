package com.sandun.personal.project;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import com.sandun.personal.project.config.SandunLewkeApplication;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link SandunLewkeApplication}. This is a deliberate separation of
 * concerns and allows the application to run:
 * 
 * @author Sandun Lewke
 */
@EnableAutoConfiguration
@Import(SandunLewkeApplication.class)
public class ApplicationServer {

	protected Logger logger = Logger.getLogger(ApplicationServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 *
	 */
	public static void main(String[] args) {

	    	System.setProperty("spring.config.name", "sandun-personal-project");
		SpringApplication.run(ApplicationServer.class, args);
	}
}
