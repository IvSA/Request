package com.work.request;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = RequestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestApplicationTests {
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@LocalServerPort
//	private int port;
//
//	private String getRootUrl() {
//		return "http://localhost:" + port;
//	}
//
//	@Test
//	public void contextLoads() {
//	}
//
//
//	@Test
//	public void testGetAllRequests() {
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/requests",
//				HttpMethod.GET, entity, String.class);
//		Assert.assertNotNull(response.getBody());
//	}
//
//	@Test
//	public void testGetRequestById() {
//		Request request = restTemplate.getForObject(getRootUrl() + "/requests/16", Request.class);
//		System.out.println(request.getDescription());
//		Assert.assertNotNull(request);
//	}
//
//	@Test
//	public void testCreateRequest() {
//		Request request = new Request();
//		request.setDescription("Тестовая заявка");
//		ResponseEntity<Request> postResponse = restTemplate.postForEntity(getRootUrl() + "/requests", request, Request.class);
//		Assert.assertNotNull(postResponse);
//		Assert.assertNotNull(postResponse.getBody());
//	}
}
