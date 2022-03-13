package com.cg.mtb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.ResponseInfo.ResponseInfo;
import com.cg.mtb.entities.Customer;
import com.cg.mtb.exception.CustomerNotFoundByIdException;
import com.cg.mtb.service.ICustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;

	@GetMapping("/customers")
		List<Customer> viewAll()
		{
		
			return customerService.viewAll();
		}
	
	@GetMapping("/customers/{customerId}")
	Customer findById(@PathVariable("customerId") int customerId)throws CustomerNotFoundByIdException
	{
		return customerService.findById(customerId);
	}
	
	@PostMapping("/customers")
	ResponseEntity<ResponseInfo> insertedCustomer(@RequestBody Customer customer,HttpServletRequest request)
	{
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		String encodePwd=bcrypt.encode(customer.getPassword());
		customer.setPassword(encodePwd);
		
		String msg = customerService.addCustomer(customer);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
        ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
        return rentity;
		
	}
	
	@PutMapping("/customers")
	ResponseEntity<ResponseInfo> updatedCustomer(@RequestBody Customer c, HttpServletRequest request)
	{
		String msg=customerService.updateCustomer(c);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
	}
        
	@DeleteMapping("/customers/{id}")
		ResponseEntity<ResponseInfo> deletedCustomer(@PathVariable("id") int id, HttpServletRequest request)throws CustomerNotFoundByIdException
	{
			String msg=customerService.deleteCustomerById(id);
			ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
			ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
			return rentity;
	}
}
