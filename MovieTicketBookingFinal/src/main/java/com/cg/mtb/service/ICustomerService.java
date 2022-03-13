package com.cg.mtb.service;

import java.util.List;

import com.cg.mtb.entities.Customer;
import com.cg.mtb.exception.CustomerNotFoundByIdException;


public interface ICustomerService {

	public String addCustomer(Customer customer);

	public Customer findById(int customerId)throws CustomerNotFoundByIdException;

	public List<Customer> viewAll();

	public String updateCustomer(Customer c);

	public String deleteCustomerById(int customerId)throws CustomerNotFoundByIdException;

	
}
