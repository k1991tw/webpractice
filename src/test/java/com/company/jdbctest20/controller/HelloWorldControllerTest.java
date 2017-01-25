package com.company.jdbctest20.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.company.jdbctest20.model.Match1;
import com.company.jdbctest20.service.Match1Service;
import com.example.DemoApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={DemoApplication.class},webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {
	private MockMvc mockMvc;
//	@Autowired
//	protected Match1Service match1Service;
	
	@Autowired
	HelloWorldController test ;;
	@Before
	public void setup() throws Exception {
		FormattingConversionService cs = new DefaultFormattingConversionService();
		HelloWorldController target = test ;
		this.mockMvc = standaloneSetup(target)
				.setConversionService(cs).alwaysExpect(status().isOk()).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testTestReadMatch1() throws Exception {
		// this.mockMvc.perform(get("/hello-world/readAll").param("value", "3"))
		// .andExpect(content().string("Converted primitive 3"));
		String content = this.mockMvc
				.perform(get("/hello-world/readAll").param("value", "3"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test	
	public void testTestSaveMatch1() throws Exception {
		 
		
		this.mockMvc
				.perform(get("/hello-world/update?id=1&court=1&crt=2&day1=3&event=3"));
	}

	@Test
	@Ignore
	public void testTestUpdateMatch1() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	@Ignore
	public void testTestDeleteMatch1ById() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}

@Configuration
@ImportResource(locations = {"classpath:spring/business-config.xml"})
class TestRestTemplateConfiguration {

}