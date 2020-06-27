package com.productstore.rest.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.productstore.rest.boot.ProductStoreApplication;

@SpringBootTest(classes = ProductStoreApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductResourceTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnResponseWithTypeSubscription() throws Exception {
		this.mockMvc.perform(get("/product")
					.param("type", "subscription"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].type").value("subscription"));
	}
	
	@Test
	public void shouldReturnResponseWithTypePhone() throws Exception {
		this.mockMvc.perform(get("/product")
					.param("type", "phone"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].type").value("phone"));
	}
	
	
	@Test
	public void shouldReturnResponseWithPropertyColor() throws Exception {
		this.mockMvc.perform(get("/product")
					.param("type", "phone")
					.param("property:color", "purpur"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].properties").value("color:purpur"));
	}
	
	@Test
	public void shouldReturnEmptyResponseWithMinGbLimitNotExists() throws Exception {
		this.mockMvc.perform(get("/product")
					.param("type", "phone")
					.param("property:gb_limit_min", "70"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data", IsCollectionWithSize.hasSize(0)));
	}
	
	@Test
	public void shouldReturnEmptyResponseWithMaxGbLimitNotExists() throws Exception {
		this.mockMvc.perform(get("/product")
					.param("type", "phone")
					.param("property:gb_limit_max", "5"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data", IsCollectionWithSize.hasSize(0)));
	}
	
	
	@Test
	public void shouldReturnEmptyResponseWithMinPrice() throws Exception {
		this.mockMvc.perform(get("/product")
					.param("type", "subscription")
					.param("property:min_price", "100"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].price", Double.class).value(Matchers.greaterThanOrEqualTo(100.00)));
		
	}
	
	@Test
	public void shouldReturnEmptyResponseWithMaxPrice() throws Exception {
		this.mockMvc.perform(get("/product")
					.param("type", "subscription")
					.param("max_price", "0"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data", IsCollectionWithSize.hasSize(0)));
		
	}
	
	
	@Test
	public void shouldReturnResponseEmptyResponse() throws Exception {
		this.mockMvc.perform(get("/product")
					.param("type", "nosubscription"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data", IsCollectionWithSize.hasSize(0)));
	}
}
