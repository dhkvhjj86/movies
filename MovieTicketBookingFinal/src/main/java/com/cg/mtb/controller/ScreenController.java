package com.cg.mtb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.ResponseInfo.ResponseInfo;
import com.cg.mtb.entities.Screen;
import com.cg.mtb.exception.ScreenNotFoundByIdException;
import com.cg.mtb.exception.ScreenNotFoundByNameException;
import com.cg.mtb.service.IScreenservices;




	@RestController
	public class ScreenController {
		@Autowired
		IScreenservices screenService;
		//private Logger logger=GlobalResources.getLogger(TheatreServiceImpl.class);
		@GetMapping("/screens")
			List<Screen> getAllScreens()
			{
			//String methodName="getAllTheatres()";
			//logger.info(methodName+"Called");
				return screenService.getAllScreens();
			}
		
		@GetMapping("/screens/byName/{name}")
		Screen getScreenByName(@PathVariable("name") String tname)throws ScreenNotFoundByNameException
		{
			//String methodName="getTheatresByName()";
			//logger.info(methodName+"Called");
			return screenService.getScreenByName(tname);
		}
		@GetMapping("/screens/{id}")
		Screen  getScreenById(@PathVariable("id") int id) throws ScreenNotFoundByIdException
		{
			//String methodName="getTheatresById()";
			//logger.info(methodName+"Called");
			return screenService. getScreenById(id);
		} 
		
		@PostMapping("/screens")
		ResponseEntity<ResponseInfo> insertedScreens(@RequestBody Screen screen,HttpServletRequest request)
		{
			//String methodName="addTheatres()";
			//logger.info(methodName+"Called");
			String msg = screenService.addScreen(screen );
			ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
	        ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
	        return rentity;
			
		}
		
		@PutMapping("/screens")
		ResponseEntity<ResponseInfo> updatedTheatres(@RequestBody Screen name, HttpServletRequest request)
		{
			//String methodName="updateTheatres()";
			//logger.info(methodName+"Called");
			String msg=screenService.updateScreen(name);
			ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
			ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
			return rentity;
		}
	        
		@DeleteMapping("/screens/{id}")
			ResponseEntity<ResponseInfo> deletedScreen(@PathVariable("id") int id, HttpServletRequest request)throws ScreenNotFoundByIdException
		{
			//String methodName="deleteTheatresById()";
			//logger.info(methodName+"Called");
				String msg=screenService.deleteScreenById(id);
				ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
				ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
				return rentity;
		}
		
}
