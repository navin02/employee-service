package com.infoiv.springmvcshowcase;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class UsingMockMvcApplicationTests {

//	@Autowired
//	private MockMvc mvc;
//
//	private Employee emp;
//	private Address addr;
//
//	private static int empId = 1;
//
//	@Before
//	public void SetUp() {
//		emp = new Employee();
//		emp.setEmpId("12");
//		emp.setMobileNum("01235455");
//		emp.setName("bhim");
//		addr = new Address();
//		addr.setCity("ah");
//		addr.setEmpId("12");
//		addr.setPinCode("560017");
//		addr.setStreet("hal main road");
//		emp.setAddress(addr);
//	}
//
//	@Test
//	public void testListAllEmployees() {
//		try {
//			MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON))
//					.andReturn();
//
//			int status = result.getResponse().getStatus();
//			String content = result.getResponse().getContentAsString();
//			System.out.println(status);
//			String empListJson = "[{\"empId\":\"1\",\"name\":\"9426839784\",\"mobileNum\":\"navin\",\"address\":{\"empId\":\"1\",\"street\":\"Bangalore\",\"pinCode\":\"560017\",\"city\":\"hal road\"}},{\"empId\":\"2\",\"name\":\"7348827203\",\"mobileNum\":\"shah\",\"address\":{\"empId\":\"2\",\"street\":\"fatepura\",\"pinCode\":\"389172\",\"city\":\"ploice station road\"}}]";
//			JSONAssert.assertEquals(content, empListJson, JSONCompareMode.STRICT);
//			assertTrue(status == 200);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testEmpById() {
//		try {
//			MvcResult result = mvc
//					.perform(MockMvcRequestBuilders.get("/employees/" + empId).accept(MediaType.APPLICATION_JSON))
//					.andReturn();
//			int status = result.getResponse().getStatus();
//			String content = result.getResponse().getContentAsString();
//			String empJson = "{\n" + "    \"empId\": \"1\",\n" + "    \"name\": \"9426839784\",\n"
//					+ "    \"mobileNum\": \"navin\",\n" + "    \"address\": {\n" + "        \"empId\": \"1\",\n"
//					+ "        \"street\": \"Bangalore\",\n" + "        \"pinCode\": \"560017\",\n"
//					+ "        \"city\": \"hal road\"\n" + "    }\n" + "}";
//			JSONAssert.assertEquals(content, empJson, JSONCompareMode.STRICT);
//			assertTrue(status == 200);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testAddEmployee() {
//		String empContent;
//		try {
//			empContent = EmployeeUtil.mapToJson(emp);
//			// String test="["+empContent+"]";
//			MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/employees").accept(MediaType.APPLICATION_JSON)
//					.content(empContent).contentType(MediaType.APPLICATION_JSON)).andReturn();
//			int status = result.getResponse().getStatus();
//			String content = result.getResponse().getContentAsString();
//			assertTrue(201 == status && content.contains("12"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
