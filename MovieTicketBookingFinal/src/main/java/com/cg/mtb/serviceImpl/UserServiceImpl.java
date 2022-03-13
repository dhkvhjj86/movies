package com.cg.mtb.serviceImpl;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.mtb.entities.SignIn;
import com.cg.mtb.entities.User;
import com.cg.mtb.exception.UserNotFoundException;
import com.cg.mtb.repository.UserRepository;
import com.cg.mtb.service.IUserService;
import com.cg.mtb.utilities.GlobalResources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("IUserService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository iUserRepository;

	@Override
	public ResponseEntity signIn(User user) throws UserNotFoundException {
		try {
			for(User i : iUserRepository.findAll()) {
				if(user.getUsername().equals(i.getUsername())) {
					if(user.getPassword().equals(i.getPassword())) {
						return new ResponseEntity("signIn successfully done!",HttpStatus.OK);
					}
					return new ResponseEntity("signIn Failed, Check username and password",HttpStatus.NOT_FOUND);
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found! Invalid details");
		}
		return new ResponseEntity("signIn process successfully done!",HttpStatus.OK);
	}

	@Override
	public ResponseEntity addUser(User user) throws UserNotFoundException {
		iUserRepository.saveAndFlush(user);
		return new ResponseEntity("User added successfully!",HttpStatus.OK);
	}

	@Override
	public ResponseEntity removeUser(User user) throws UserNotFoundException {
		User bean = null;
		try {
			bean = iUserRepository.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		iUserRepository.deleteById(user.getUserId());
		return new ResponseEntity("User deleted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity signOut(User user) throws UserNotFoundException {
		try {
			if(signIn(user).equals("Authentication successfully done!") && signIn(user).getStatusCodeValue()==200) {
				return new ResponseEntity("Signed Out successfully",HttpStatus.OK);
			}
			else {
				return new ResponseEntity("Invalid Privilege",HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity("Signed Out successfully",HttpStatus.OK);
	}

}
