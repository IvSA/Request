package com.work.request;

import com.work.request.model.Request;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RequestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}


	@Test
	public void testGetAllRequests() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/requests",
				HttpMethod.GET, entity, String.class);
		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetRequestById() {
		Request request = restTemplate.getForObject(getRootUrl() + "/requests/16", Request.class);
		System.out.println(request.getDescription());
		Assert.assertNotNull(request);
	}

	@Test
	public void testCreateRequest() {
		Request request = new Request();
		request.setDescription("Тестовая заявка");
		ResponseEntity<Request> postResponse = restTemplate.postForEntity(getRootUrl() + "/requests", request, Request.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
}
