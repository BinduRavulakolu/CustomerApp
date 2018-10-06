package com.capgemini.customer;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.controller.CustomerController;
import com.capgemini.customer.entities.Customer;
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
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

	}

	/*@Test
	public void testAddCustomer() throws Exception {
		when(customerService.addCustomer(Mockito.isA(Customer.class)))
				.thenReturn(new Customer(12345, "Bindu", "Hyderabad", "bindu@gmail.com", "12"));
		String content = "{\"customerId\": \"12345\",\r\n" + "  \"customerName\": \"Bindu\",\r\n"
				+ "  \"customerAddress\": \"Hyderabad\",\r\n" + "  \"customerEmail\": \"bindu@gmail.com\",\r\n"
				+ "  \"customerPassword\": \"12\"}";
		mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON).content(content)

				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.customerId").exists()).andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customerAddress").exists()).andExpect(jsonPath("$.customerEmail").exists())
				.andExpect(jsonPath("$.customerName").value("Bindu"))
				.andExpect(jsonPath("$.customerAddress").value("Hyderabad")).andDo(print());
	}
*/
	
	@Test
	public void testAuthenticateCustomer() throws Exception {
		
		String content = "{\"customerId\": 123465,\r\n" + 
				"  \"customerPassword\": \"12\"}";
		Customer customer = new Customer(12345, "Bindu", "Banglore", "bindu@gmail.com", "12");
		when(customerService.authenticate(Mockito.isA(Integer.class), Mockito.isA(String.class))).thenReturn(customer);
		mockMvc.perform(post("/customer/auth").content(content).contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print())
		.andExpect(jsonPath("$.customerAddress").exists())
		.andExpect(jsonPath("$.customerEmail").exists())
		.andExpect(jsonPath("$.customerAddress").value("Banglore"))
		.andExpect(jsonPath("$.customerEmail").value("bindu@gmail.com"));
		verify(customerService).authenticate(Mockito.isA(Integer.class), Mockito.isA(String.class));
	}
	/*@Test
	public void testgetCustomerById() throws Exception {

		when(customerService.getCustomerById(12345)).thenReturn(new Customer(12345, "Bindu", "Hyderabad", "bindu@gmail.com", "12") );

		mockMvc.perform(MockMvcRequestBuilders.get("/customer/12345").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customerAddress").exists())
				.andExpect(jsonPath("$.customerEmail").exists())
				.andExpect(jsonPath("$.customerPassword").exists())
				
				.andExpect(jsonPath("$.customerId").value(12345))
				.andExpect(jsonPath("$.customerName").value("Bindu"))
				.andExpect(jsonPath("$.customerAddress").value("Hyderabad"))
				.andExpect(jsonPath("$.customerEmail").value("bindu@gmail.com"))
				.andExpect(jsonPath("$.customerPassword").value("12"))

				.andDo(print());
	}
	*/
	/*@Test
	public void testUpdateCustomer() throws Exception {

		when(customerService.updateCustomer(Mockito.isA(Customer.class))).thenReturn(new Customer(12345, "Bindu", "Banglore", "bindu@gmail.com","12"));

		String content = "{\"customerId\": \"12345\",\r\n" + 
				"  \"customerName\": \"Bindu\",\r\n" + 
				"  \"customerAddress\": \"Banglore\",\r\n" + 
				"  \"customerEmail\": \"bindu@gmail.com\",\r\n" + 
				"  \"customerPassword\": \"12\"}";

		mockMvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON).content(content)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())

//				.andExpect(jsonPath("$.customerId").exists())
				.andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customerAddress").exists())
				.andExpect(jsonPath("$.customerEmail").exists())
				.andExpect(jsonPath("$.customerPassword").exists())

//				.andExpect(jsonPath("$.customerId").value(12345))
				.andExpect(jsonPath("$.customerName").value("Bindu"))
				.andExpect(jsonPath("$.customerAddress").value("Banglore"))
				.andExpect(jsonPath("$.customerEmail").value("bindu@gmail.com"))
				.andExpect(jsonPath("$.customerPassword").value("12"))


				.andDo(print());

	}*/
	
	/*@Test
	public void testDeleteCustomer() throws Exception {
		when(customerService.getCustomerById(12345)).thenReturn(new Customer(12345, "Bindu", "Banglore", "bindu@gmail.com","12"));
		mockMvc.perform(delete("/customer/12345").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

		verify(customerService, times(1)).deleteCustomer(12345);
	}*/


}
