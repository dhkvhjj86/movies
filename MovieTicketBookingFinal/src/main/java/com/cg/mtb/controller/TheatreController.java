package com.cg.mtb.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.ResponseInfo.ResponseInfo;
import com.cg.mtb.entities.Theatre;
import com.cg.mtb.exception.TheatreNotFoundByIdException;
import com.cg.mtb.exception.TheatreNotFoundByNameException;
import com.cg.mtb.service.ITheatreService;
import com.cg.mtb.serviceImpl.TheatreServiceImpl;
import com.cg.mtb.utilities.GlobalResources;



@Validated(Theatre.class)
@RestController
public class TheatreController {
	@Autowired
	ITheatreService theatreService;
	private Logger logger=GlobalResources.getLogger(TheatreServiceImpl.class);
	@GetMapping("/theatres")
		List<Theatre> getAllTheatres()
		{
		String methodName="getAllTheatres()";
		logger.info(methodName+"Called");
			return theatreService.getAllTheatres();
		}
	
	@GetMapping("/theatres/byName/{name}")
	Theatre getTheatresByName(@PathVariable("name") String tname)throws TheatreNotFoundByNameException
	{
		String methodName="getTheatresByName()";
		logger.info(methodName+"Called");
		return theatreService.getTheatresByName(tname);
	}
	@GetMapping("/theatres/{id}")
	Theatre getTheatresById(@PathVariable("id") int id) throws TheatreNotFoundByIdException
	{
		String methodName="getTheatresById()";
		logger.info(methodName+"Called");
		return theatreService.getTheatresById(id);
	} 
	
	@PostMapping("/theatres")
	ResponseEntity<ResponseInfo> insertedTheatres(@RequestBody Theatre theatre,HttpServletRequest request)
	{
		String methodName="addTheatres()";
		logger.info(methodName+"Called");
		String msg = theatreService.addTheatres(theatre );
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
        ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
        return rentity;
		
	}
	
	@PutMapping("/theatres")
	ResponseEntity<ResponseInfo> updatedTheatres(@RequestBody Theatre name, HttpServletRequest request)
	{
		String methodName="updateTheatres()";
		logger.info(methodName+"Called");
		String msg=theatreService.updateTheatres(name);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
	}
        
	@DeleteMapping("/theatres/{id}")
		ResponseEntity<ResponseInfo> deletedTheatres(@PathVariable("id") int id, HttpServletRequest request)throws TheatreNotFoundByIdException
	{
		String methodName="deleteTheatresById()";
		logger.info(methodName+"Called");
			String msg=theatreService.deleteTheatresById(id);
			ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
			ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
			return rentity;
	}
	
}