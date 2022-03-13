package com.cg.mtb.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtb.entities.Customer;
import com.cg.mtb.exception.CustomerNotFoundByIdException;
import com.cg.mtb.repository.ICustomerRepository;
import com.cg.mtb.service.ICustomerService;


@Service
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public String addCustomer(Customer customer) 
	{
		customerRepository.save(customer);
		return "Inserted Successfully!!";
	}

	@Override
	public Customer findById(int customerId)throws CustomerNotFoundByIdException
	{
		Optional<Customer> op=customerRepository.findById(customerId);
		if(op.isPresent()) 
			return op.get();
		else
			throw new CustomerNotFoundByIdException("customer id not found");
			
			
	}
	
	@Override
	public String updateCustomer(Customer c) 
	{
		
		customerRepository.save(c);
		return "Updated Successfully!!";
	}

	@Override
	public String deleteCustomerById(int customerId)throws CustomerNotFoundByIdException 
	{
		Optional<Customer> op=customerRepository.findById(customerId);
		if(op.isPresent()) {
			customerRepository.deleteById(customerId);
			return "Deleted Successfully!!";
		}
	else 
		throw new CustomerNotFoundByIdException("no customer found for this id:"+customerId); 
	}

	@Override
	public List<Customer> viewAll() 
	{

     List<Customer> cus = customerRepository.findAll();
	 return cus;
	}
		
	}
		
	

	
