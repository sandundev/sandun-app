package com.sandun.personal.project.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.sandun.personal.project.ApplicationServer;
import com.sandun.personal.project.config.SandunLewkeApplication;
import com.sandun.personal.project.model.core.SandunLewke;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SandunLewkeApplication.class , ApplicationServer.class}, webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class SandunLewkeResourceControllerIT {

	@Autowired
	private TestRestTemplate restTemplate  ;

	@Test
	public void testRetrieveSandunLewke() {

		String serviceUrl = "/sandun-personal-project/sandun-lewke/5";
		ResponseEntity<SandunLewke> responseSandunLewke = restTemplate.getForEntity(serviceUrl, SandunLewke.class);
		SandunLewke sandunLewke = responseSandunLewke.getBody();
		
		assertEquals(sandunLewke.getProfileId(), "sandun22333");
		assertEquals(sandunLewke.getFirstname(), "jorge22333");

	}


	@Test(expected = HttpClientErrorException.class)
	public void testNonExistingSandunLewke() {

		String serviceUrl = "/sandun-personal-project/sandun-lewke/001";

		restTemplate.getForEntity(serviceUrl, SandunLewke.class);

	}

	@Test
	public void testCreateNewClientProfle() {

		String serviceUrl = "/sandun-personal-project/sandun-lewke/";

		SandunLewke requestSandunLewke = new SandunLewke();
		requestSandunLewke.setProfileId(111L);
		requestSandunLewke.setFirstname("Client_test");
		requestSandunLewke.setSurname("Surname test");

		ResponseEntity<SandunLewke> responseSandunLewke = restTemplate.postForEntity(serviceUrl, new HttpEntity<SandunLewke>(requestSandunLewke), SandunLewke.class);

		assertThat(responseSandunLewke.getStatusCode(), is(HttpStatus.CREATED));
		
		SandunLewke sandunLewke = responseSandunLewke.getBody();
		assertEquals(sandunLewke.getFirstname(), "Client_test");
		assertEquals(sandunLewke.getSurname(), "Surname test");
		

	}

}
