package com.cg.mtb.service;

import org.springframework.http.ResponseEntity;

import com.cg.mtb.entities.User;
import com.cg.mtb.exception.UserNotFoundException;

  public interface IUserService {
	  public ResponseEntity signIn(User user)throws UserNotFoundException;
	  public ResponseEntity addUser(User user) throws UserNotFoundException;
	  public ResponseEntity removeUser(User user) throws UserNotFoundException;
	  public ResponseEntity signOut(User user) throws UserNotFoundException; }
  
 
