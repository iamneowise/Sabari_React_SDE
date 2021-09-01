package com.example;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BookstoreApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;	
	 
	//Testing Login and Sign Up 
	@Test
    public void test_case1() throws Exception {
		 
		//Sign Up
	 	String userOne = "{\"email\":\"Test@gmail.com\",\"username\":\"TestSignup\",\"mobileNumber\":\"1234598760\",\"role\":\"ADMIN\",\"password\":\"Testing\",\"confirmPassword\":\"Testing\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/signup")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(userOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andDo(print())
	        	.andExpect(content().json("{\"email\":\"Test@gmail.com\",\"password\":\"Testing\",\"username\":\"TestSignup\",\"role\":\"ADMIN\",\"mobileNumber\":\"1234598760\"}"))
	        	.andReturn();
	 		    
	 	//Login
	    String dataOne = "{\"email\":\"Test@gmail.com\",\"password\":\"Testing\"}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/login")
	    		.contentType(MediaType.APPLICATION_JSON)
	    		.content(dataOne)
	    		.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andExpect(content().json("{\"email\":\"Test@gmail.com\",\"password\":\"Testing\",\"username\":\"TestSignup\",\"role\":\"ADMIN\",\"mobileNumber\":\"1234598760\"}"))
	        	.andReturn();
    }
	 
	 
	//Add Product
	@Test
	public void test_case2() throws Exception {
		String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL\",\"productName\":\"TestingName\",\"price\":\"100\",\"description\":\"TestingDescription\",\"quantity\":10}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
	    		.contentType(MediaType.APPLICATION_JSON)
	    		.content(prodOne)
	    		.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
    }
	 
	 
	 //Home
	 @Test
	 public void test_case3() throws Exception {
		 
		 String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL1\",\"productName\":\"TestingName1\",\"price\":\"100\",\"description\":\"TestingDescription1\",\"quantity\":10}";
		 mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
				.contentType(MediaType.APPLICATION_JSON)
				.content(prodOne)
				.accept(MediaType.APPLICATION_JSON))
		 		.andExpect(status().isOk())
		 		.andReturn();
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/products")
				.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andDo(print())
	        	.andExpect(MockMvcResultMatchers.jsonPath("$[*].productName").exists())
	        	.andReturn();
	 }
	 
	 
	 @Test
	 public void test_case4() throws Exception {
		 
		 String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL1\",\"productName\":\"TestingName1\",\"price\":\"100\",\"description\":\"TestingDescription1\",\"quantity\":10}";
		 mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
		 		.contentType(MediaType.APPLICATION_JSON)
		        .content(prodOne)
		        .accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andReturn();
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/products")
				.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andDo(print())
	        	.andExpect(MockMvcResultMatchers.jsonPath("$[*].productName").exists())
	        	.andReturn();		    
	 }
	 
	 
	 @Test
	 public void test_case5() throws Exception {
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/user/Test@gmail.com/orders")
				.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 }
	 
	 
}
