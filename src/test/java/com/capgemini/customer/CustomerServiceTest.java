package com.capgemini.customer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.entities.Customer;
import com.capgemini.customer.repository.CustomerRepository;
import com.capgemini.customer.service.impl.CustomerServiceImpl;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	CustomerRepository customerRepository;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
	MockitoAnnotations.initMocks(this);
	mockMvc=MockMvcBuilders.standaloneSetup(customerServiceImpl).build();

	}
//	
//	@Test
//	public void testAddCustomer() {
//		Customer customer=new Customer(12345, "Bindu", "Hyderabad", "bindu@gmail.com", "12");
//		when(customerRepository.save(customer)).thenReturn(customer);
//		assertEquals(customerServiceImpl.addCustomer(customer),customer);
//		
//	}
	
	@Test
	public void testAthenticate(){
		Customer customer=new Customer(12345, "Bindu", "Hyderabad", "bindu@gmail.com", "12");
		Optional<Customer> customer1 = Optional.of(customer);
		when(customerRepository.findById(12345)).thenReturn(customer1);  
		assertEquals(customerServiceImpl.authenticate(12345, "12"),customer);
	}
	
	/*@Test
	public void testCustomerById() {
		Customer customer=new Customer(12345, "Bindu", "Hyderabad", "bindu@gmail.com", "12");
		Optional<Customer> customer1 = Optional.of(customer);
		when(customerRepository.findById(12345)).thenReturn(customer1);  
		assertEquals( customerServiceImpl.getCustomerById(12345),customer);
		}
	*/
	/*@Test
	public void testUpdateCustomer() {

		Customer customer1=new Customer(12345, "Bindu", "Hyderabad", "bindu@gmail.com", "12");
		Customer customer2=new Customer(12345, "Bindu", "Bangalore", "bindu@gmail.com", "12");
		when(customerRepository.save(customer1)).thenReturn(customer2);
		assertEquals(customerServiceImpl.updateCustomer(customer1),customer2);
		
		
	}*/
	
/*	@Test
	public void testDeleteCustomer() {
		
		customerServiceImpl.deleteCustomer(12345);
		verify(customerRepository, times(1)).deleteById(12345);
	}*/

	
	
}
