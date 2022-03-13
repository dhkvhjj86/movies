package com.cg.mtb.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.mtb.entities.Customer;
import com.cg.mtb.entities.User;
import com.cg.mtb.repository.UserRepository;
import com.cg.mtb.serviceImpl.UserServiceImpl;

class testUserServiceImpl {

	@Mock
	UserRepository ur;
	@InjectMocks
	UserServiceImpl usi;
	User u;


	@BeforeEach
	public void init() { 
		MockitoAnnotations.initMocks(this);
		//u=new User(101, "megha", "customer",null, new Customer(0,"asha","gvAS","Hsuh","tru","hehns"));
	}
	/*
	 * @Test void testAddNewUser() { Mockito.when(ur.save(u)).thenReturn(u);
	 * //String actulResult=service.addCustomer(customer); String
	 * excpectedResult="user added successfully"; assertEquals(excpectedResult,
	 * usi.addUser(u)); Mockito.verify(ur, Mockito.times(1)).save(u);
	 * 
	 * }
	 */
	
	
	
	/*
	 * @Test void testdeleteUserById() { int id=101;
	 * //Mockito.when(ur.deleteById(id)).thenReturn (); String
	 * expectedResult="user is deleted successfully";
	 * assertEquals(expectedResult,usi.deleteUserById(id));
	 * Mockito.verify(ur,Mockito.times(1)).deleteById(id); }
	 */
	  
	  
	  
	 
	/*
	 * @Test void testgetByUserIdFailure() { int id=-101;
	 * Mockito.when(ur.findById(id)).thenReturn(Optional.empty());
	 * assertThrows(UserNotFoundException.class,()->usi.getByUserId(id));
	 * Mockito.verify(ur,Mockito.times(1)).findById(id); }
	 */
}
