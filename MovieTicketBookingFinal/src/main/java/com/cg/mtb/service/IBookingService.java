package com.cg.mtb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.mtb.entities.Booking;
import com.cg.mtb.exception.BookingNotFoundException;


public interface IBookingService {
	
	public String addBooking(Booking booking);
	public List<Booking> showBookingList(int showId) throws BookingNotFoundException;
	public String updateBooking(Booking booking) throws BookingNotFoundException;
	public String deleteBooking(int bookingId)throws BookingNotFoundException;
	public List<Booking> showAllBookings(int movieId)throws BookingNotFoundException;
	public List<Booking> showAllBookingsDate(LocalDate bookingDate) throws BookingNotFoundException;
	//public double calculateTotalCost(int bookingId)throws BookingNotFoundException;
	
	
}
