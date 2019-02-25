//package com.infoiv.springmvcshowcase;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.json.JSONException;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.infoiv.springmvcshowcase.model.Address;
//import com.infoiv.springmvcshowcase.model.Employee;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringmvcshowcaseApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//public class SpringmvcshowcaseApplicationTests {
//	@LocalServerPort
//	int randomServerPort;
//
//	@Autowired
//	TestRestTemplate template;
//
//	public static final String httpHost = "http://localhost:";
//
//	public static final String sourcePoint = "/employees";
//
//	@Test
//	public void testGetEmployeeList() {
//		// RestTemplate restTemplate = new RestTemplate();
//
//		final String baseUrl = httpHost + randomServerPort + sourcePoint;
//
//		try {
//			URI uri = new URI(baseUrl);
//			ResponseEntity<String> entity = template.getForEntity(uri, String.class);
//			Assert.assertEquals(200, entity.getStatusCodeValue());
//			String empListJson = "[{\"empId\":\"1\",\"name\":\"9426839784\",\"mobileNum\":\"navin\",\"address\":{\"empId\":\"1\",\"street\":\"Bangalore\",\"pinCode\":\"560017\",\"city\":\"hal road\"}},{\"empId\":\"2\",\"name\":\"7348827203\",\"mobileNum\":\"shah\",\"address\":{\"empId\":\"2\",\"street\":\"fatepura\",\"pinCode\":\"389172\",\"city\":\"ploice station road\"}}]";
//			JSONAssert.assertEquals(empListJson, entity.getBody(), false);
//
//		} catch (URISyntaxException | JSONException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testGetEmployeeById() {
//		// RestTemplate template = new RestTemplate();
//
//		final String baseUrl = httpHost + randomServerPort + sourcePoint + "/1";
//
//		try {
//			URI url = new URI(baseUrl);
//			ResponseEntity<String> response = template.getForEntity(url, String.class);
//			String empJson = "{\n" + "    \"empId\": \"1\",\n" + "    \"name\": \"9426839784\",\n"
//					+ "    \"mobileNum\": \"navin\",\n" + "    \"address\": {\n" + "        \"empId\": \"1\",\n"
//					+ "        \"street\": \"Bangalore\",\n" + "        \"pinCode\": \"560017\",\n"
//					+ "        \"city\": \"hal road\"\n" + "    }\n" + "}";
//			JSONAssert.assertEquals(empJson, response.getBody(), false);
//		} catch (URISyntaxException | JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testGetEmployeeByIdUsingParam() {
//		// RestTemplate template = new RestTemplate();
//
//		final String baseUrl = httpHost + randomServerPort + sourcePoint + "/{id}";
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("id", "1");
//		try {
//			// URI url = new URI(baseUrl);
//			ResponseEntity<String> response = template.getForEntity(baseUrl, String.class, param);
//			String empJson = "{\n" + "    \"empId\": \"1\",\n" + "    \"name\": \"9426839784\",\n"
//					+ "    \"mobileNum\": \"navin\",\n" + "    \"address\": {\n" + "        \"empId\": \"1\",\n"
//					+ "        \"street\": \"Bangalore\",\n" + "        \"pinCode\": \"560017\",\n"
//					+ "        \"city\": \"hal road\"\n" + "    }\n" + "}";
//			JSONAssert.assertEquals(empJson, response.getBody(), false);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	//@Test
////	public void testAddEmployee() {
////		// RestTemplate template = new RestTemplate();
////
////		final String baseUrl = httpHost + randomServerPort + sourcePoint;
////		Employee emp = new Employee();
////		emp.setEmpId("12");
////		emp.setMobileNum("01235455");
////		emp.setName("bhim");
////		Address addr = new Address();
////		addr.setCity("ah");
////		addr.setEmpId("12");
////		addr.setPinCode("560017");
////		addr.setStreet("hal main road");
////		emp.setAddress(addr);
////		try {
////			URI url = new URI(baseUrl);
////			template.postForEntity(url, emp, String.class);
////		} catch (URISyntaxException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//
//	// @Test
//	// public void testUpdateEmployee() {
//	// RestTemplate template = new RestTemplate();
//	//
//	// final String baseUrl = httpHost + randomServerPort +
//	// "/emloyees/{id}";
//	//
//	// Employee emp = new Employee();
//	// emp.setEmpId("1");
//	// emp.setMobileNum("01235455");
//	// emp.setName("bhim");
//	// Address addr = new Address();
//	// addr.setCity("ah");
//	// addr.setEmpId("1");
//	// addr.setPinCode("560017");
//	// addr.setStreet("hal main road");
//	// emp.setAddress(addr);
//	// Map<String, String> param = new HashMap<String, String>();
//	// param.put("id", "1");
//	//
//	// template.put(baseUrl, emp, param);
//	//
//	// }
//}
