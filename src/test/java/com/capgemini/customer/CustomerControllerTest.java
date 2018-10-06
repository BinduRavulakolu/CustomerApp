package com.capgemini.customer;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.controller.CustomerController;
import com.capgemini.customer.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerControllerTest {
	
	
	@InjectMocks
	private CustomerController customerController;

	@Mock
	private CustomerService customerService;
	
	private MockMvc mockMvc;
	
	@Before
	private void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(customerController).build();

	}
}
