package com.capgemini.customer.service;

import com.capgemini.customer.entities.Customer;
import com.capgemini.customer.exceptions.CustomerAlreadyRegisteredException;
import com.capgemini.customer.exceptions.CustomerNotFoundException;

public interface CustomerService {
	public Customer addCustomer(Customer customer) throws CustomerAlreadyRegisteredException;
	public Customer authenticate(int customerId,String customerPassword) throws CustomerNotFoundException;
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException;
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(int customerId);

}
