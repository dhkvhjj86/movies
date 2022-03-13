package com.cg.mtb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.ResponseInfo.ResponseInfo;
import com.cg.mtb.entities.User;
import com.cg.mtb.exception.UserNotFoundException;
import com.cg.mtb.service.IUserService;
import com.cg.mtb.serviceImpl.UserServiceImpl;
import com.cg.mtb.utilities.GlobalResources;



@RestController
@RequestMapping("/mtb-user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@GetMapping("/signIn")
	public ResponseEntity signIn(@RequestBody User user) throws UserNotFoundException{
		return iUserService.signIn(user);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity addUser(@RequestBody User user) throws UserNotFoundException{
		return iUserService.addUser(user);
	}
	
	@DeleteMapping("/removeuser")
	public ResponseEntity removeUser(@RequestBody User user) throws UserNotFoundException{
		return iUserService.removeUser(user);
	}
	
	@GetMapping("/signout")
	public ResponseEntity signOut(@RequestBody User user) throws UserNotFoundException{
		return iUserService.signOut(user);
	}

}