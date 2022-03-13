package com.cg.mtb.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.mtb.entities.Customer;
import com.cg.mtb.exception.CustomerNotFoundByIdException;
import com.cg.mtb.repository.ICustomerRepository;
import com.cg.mtb.serviceImpl.ICustomerServiceImpl;





class TestCustomerService {
	@Mock
	ICustomerRepository repository;
	@InjectMocks
	ICustomerServiceImpl service;
	Customer customer;
	
	@BeforeEach
	public void testCommon() {
		MockitoAnnotations.initMocks(this);
		customer=new Customer(101, "Aruna", "Davangere", "999955656", "aru12@1998", "12345678");
	}
	@Test
	void testaddCustomer() {
		Mockito.when(repository.save(customer)).thenReturn(customer);
		//String actulResult=service.addCustomer(customer);
		String excpectedResult="Inserted Successfully!!";
		assertEquals(excpectedResult, service.addCustomer(customer));
		Mockito.verify(repository, Mockito.times(1)).save(customer);
	}
	@Test
	void testupdateCustomer() {
		Mockito.when(repository.save(customer)).thenReturn(customer);
		//String actulResult=service.updateCustomer(customer);
		String excpectedResult="Updated Successfully!!";
		assertEquals(excpectedResult, service.updateCustomer(customer));
		Mockito.verify(repository, Mockito.times(1)).save(customer);
	}
   	@Test
	void testdeleteCustomerById() throws CustomerNotFoundByIdException {
		int id=101;
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(customer));
        String excpectedResult="Deleted Successfully!!";
        //String actualResult=service.cancelCustomer(id);
        assertEquals(excpectedResult, service.deleteCustomerById(id));
        Mockito.verify(repository, Mockito.times(1)).findById(id);
	}
	
	
	@Test
	void testviewAll() {
		List<Customer> list=new ArrayList<>();
		list.add(new Customer(101, "Kiran", "Banglore","9798754534", "kiran12@1998","123456"));
		list.add(new Customer(102, "Rudra", "Manglore", "876654656l", "rudra12@1223","121212"));	
		
		Mockito.when(repository.findAll()).thenReturn(list);
        assertEquals(list, service.viewAll());
        Mockito.verify(repository, Mockito.times(1)).findAll();
	}
	
	@Test
	void testfindById() {
		int id=101;
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(customer));
		//String actulResult=service.updateCustomer(customer);
		assertEquals(customer, service.findById(id));
		Mockito.verify(repository, Mockito.times(1)).findById(id);
}
}
	
 