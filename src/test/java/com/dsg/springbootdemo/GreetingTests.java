package com.dsg.springbootdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dsg.springbootdemo.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingTests {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void greetWorld() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect((result) -> {
				assertEquals("Hello, World", new ObjectMapper().readValue(result.getResponse().getContentAsString(), Greeting.class).getContent());
			});
	}
	
	@Test
	public void greetRahul() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/greeting").param("name", "Rahul").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect((result) -> {
				assertEquals("Hello, Rahul", new ObjectMapper().readValue(result.getResponse().getContentAsString(), Greeting.class).getContent());
			});
	}
	
	@Test
	public void greetManoj() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/greeting").param("name", "Manoj").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect((result) -> {
				assertEquals("Hello, Manoj", new ObjectMapper().readValue(result.getResponse().getContentAsString(), Greeting.class).getContent());
			});
	}
}
