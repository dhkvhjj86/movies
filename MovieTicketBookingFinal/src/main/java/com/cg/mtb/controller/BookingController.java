package com.cg.mtb.controller;

import org.slf4j.Logger;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.mtb.ResponseInfo.ResponseInfo;
import com.cg.mtb.entities.Booking;
import com.cg.mtb.exception.BookingNotFoundException;
import com.cg.mtb.service.IBookingService;
import com.cg.mtb.serviceImpl.BookingServiceImpl;
import com.cg.mtb.utilities.GlobalResources;


@RestController
public class BookingController { 

	@Autowired	
	private IBookingService bookingService;
	
	private Logger logger=GlobalResources.getLogger(BookingServiceImpl.class);
	

	@PostMapping("/booking")
	ResponseEntity<ResponseInfo> addBooking(@Valid @RequestBody Booking booking,HttpServletRequest request)
	{
		String methodName="addBooking()";
		logger.info(methodName+"Called");
	String msg=bookingService.addBooking(booking);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
	return rentity;
	}
	
	@PutMapping("/booking")
	ResponseEntity<ResponseInfo> updateBooking(@Valid @RequestBody Booking booking,HttpServletRequest request)throws BookingNotFoundException
	{
		String methodName="updateBooking()";
		logger.info(methodName+"Called");

	String msg=bookingService.updateBooking(booking);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
	return rentity;
	}
	
	@DeleteMapping("/booking/{bookingId}")
	ResponseEntity<ResponseInfo> deleteBooking(@Valid @PathVariable("bookingId") int bookingId,HttpServletRequest request)throws BookingNotFoundException
	{
	String methodName="deleteBooking()";
		logger.info(methodName+"Called");

	String msg=bookingService.deleteBooking(bookingId);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
	return rentity;
	}
	
	@GetMapping("/booking/byMovieId/{movieId}")
	List<Booking> showAllBookings(@PathVariable("movieId")int movieId)throws BookingNotFoundException
	{
		String methodName="showAllBookings()";
		logger.info(methodName+"Called");

		return bookingService.showAllBookings(movieId);
	}
	
	@GetMapping("/booking/byShowId/{showId}")
	List<Booking> showBookingList(@PathVariable ("showId")int showId)throws BookingNotFoundException
	{
		String methodName="showBookingList()";
		logger.info(methodName+"Called");
		return  bookingService.showBookingList(showId);
	}
	
	@GetMapping("/booking/byDate/{localDate}")
	public List<Booking> showAllBookings(@PathVariable ("localDate")LocalDate bookingdate)throws BookingNotFoundException
	{
		String methodName="showAllBookings()";
		logger.info(methodName+"Called");
	return bookingService.showAllBookingsDate(bookingdate);
	}

	/*@GetMapping("/booking/byCost/{bookingId}")
	public double totalBookingcost(@PathVariable int bookingId)throws BookingNotFoundException{
		String methodName="totalBookingCost()";
		logger.info(methodName+"Called");

		return bookingService.calculateTotalCost(bookingId);
	}	*/
}
