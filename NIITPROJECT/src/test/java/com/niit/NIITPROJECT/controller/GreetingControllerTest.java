package com.niit.NIITPROJECT.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.NIITPROJECT.model.Emp;
import com.niit.NIITPROJECT.service.EmployeeService;
@RunWith(SpringRunner.class)
@WebMvcTest(value = GreetingController.class, secure = false)
public class GreetingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
    @MockBean 
    private EmployeeService employeeService;
    
    public  String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
   	public void createEmployeeTest() throws Exception {
    	List<Emp> mockallemp=new CopyOnWriteArrayList<Emp>();
    	Emp e1=new Emp(1,"SACHIN");
		Emp e2=new Emp(2,"PURNA");
		Emp e3=new Emp(3,"AMIT");
		Emp e4=new Emp(4,"NIHAR");
		mockallemp.add(e1);
		mockallemp.add(e2);
		mockallemp.add(e3);
		mockallemp.add(e4);
			
		String inputpayload = "{\"eId\":4,\"name\":\"NIHAR\"}";
    	
    	Mockito.when(employeeService.createEmployee(Mockito.anyObject())).thenReturn(mockallemp);
    	
		/*
		 * RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
		 * "/saveemployee").accept(
		 * MediaType.APPLICATION_JSON).content(asJsonString(mockreq)).contentType(
		 * MediaType.APPLICATION_JSON);
		 */
		
		//String inputbody="{"+"id:"+"1,"+"name:+"+"SACHIN}";
    	
    	ResultActions result= 
    			mockMvc.perform(
    					MockMvcRequestBuilders.post(
    							"/saveemployee")
    			  .content(inputpayload)
    			  .contentType(MediaType.APPLICATION_JSON));
    			 // .accept(MediaType.APPLICATION_JSON));
    	
    	
    	System.out.println(result.andReturn().getResponse().getStatus());
    	System.out.println(result.andReturn().getResponse().getContentAsString());
    	//System.out.println(result.getResponse().getStatus());
    	//System.out.println(result.getResponse().getContentAsString());
    	
    	
    	
    	///saveemployee
    }
	
    @Test
	public void getAllEmpTest() throws Exception {
    	List<Emp> mockallemp=new CopyOnWriteArrayList<Emp>();
    	Emp e1=new Emp(1,"SACHIN");
		Emp e2=new Emp(2,"PURNA");
		Emp e3=new Emp(3,"AMIT");
		Emp e4=new Emp(4,"NIHAR");
		mockallemp.add(e1);
		mockallemp.add(e2);
		mockallemp.add(e3);
		mockallemp.add(e4);
		Mockito.when(employeeService.getAllEmp()).thenReturn(mockallemp);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getemployees").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{eId:1,name:SACHIN},{eId:2,name:PURNA},{eId:3,name:AMIT},{eId:4,name:NIHAR}]";
		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),true); 
    }
    
    
	@Test
	public void getEmpTest() throws Exception {
		Emp mockSingleemployee=new Emp(4,"NIHAR");
		Mockito.when(
				employeeService.getEmp(Mockito.anyInt()
						)).thenReturn(mockSingleemployee);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getemployees/4").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "{eId:4,name:NIHAR}";
		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),true);

		/*
		 * System.out.println(result.getResponse().getStatus()); try {
		 * System.out.println(result.getResponse().getContentAsString()); } catch
		 * (UnsupportedEncodingException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		//String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		/*
		 * try { JSONAssert.assertEquals(expected, result.getResponse()
		 * .getContentAsString(), false); } catch (UnsupportedEncodingException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch (JSONException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		//assert(true);
	}

}
