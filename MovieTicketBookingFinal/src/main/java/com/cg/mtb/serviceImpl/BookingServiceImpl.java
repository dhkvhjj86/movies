package com.cg.mtb.serviceImpl;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.mtb.entities.Booking;
import com.cg.mtb.exception.BookingNotFoundException;
import com.cg.mtb.repository.BookingRepository;
import com.cg.mtb.service.IBookingService;
import com.cg.mtb.utilities.GlobalResources;


@Service("bookingService")
public class BookingServiceImpl implements IBookingService{
	@Autowired
	private BookingRepository bookingRepository;
	
	private Logger logger=GlobalResources.getLogger(BookingServiceImpl.class);

	@Override
	public String addBooking(Booking booking){
		String methodName="addBooking()";
		logger.info(methodName+"Called");
		// TODO Auto-generated method stub
		Booking b=bookingRepository.save(booking);
			return "Booking Added Successfully";
	}
	
	@Override
	public List<Booking> showBookingList(int showId)throws BookingNotFoundException{
		String methodName="showBookingList()";
		logger.info(methodName+"Called");
		// TODO Auto-generated method stub
		List<Booking> list=bookingRepository.findAllByShowId(showId);
		if(list !=null && list.size()>0) {
		return list;
	}
		else {
			throw new BookingNotFoundException("Booking list not found");
		}
	}

	@Override
	public String updateBooking(Booking booking){
		String methodName="updateBooking()";
		logger.info(methodName+"Called");
		// TODO Auto-generated method stub
		Booking result=bookingRepository.save(booking);
			return "Booking Updated";
		}
	
	@Override
	public String deleteBooking(int bookingId)throws BookingNotFoundException
	{
	Optional<Booking> op=bookingRepository.findById(bookingId);
	if(op.isPresent()) {
	bookingRepository.deleteById(bookingId);
	return "Deleted Successfully!!";
	}
	else
	throw new BookingNotFoundException("no booking found for this id:"+bookingId);
	}
	
	@Override
	public List<Booking> showAllBookings(int movieId)throws BookingNotFoundException{
		String methodName="showAllBookings()";
		logger.info(methodName+"Called");
		// TODO Auto-generated method stub
		List<Booking> result=bookingRepository.findAllByMovieId(movieId);
		if(result.size()==0 || result.size()<=0) {
			throw new BookingNotFoundException("No Bookings Found");
		}
		else
			return result;
	}

	@Override
	public List<Booking> showAllBookingsDate(LocalDate bookingDate)throws BookingNotFoundException{
		String methodName="showAllBookingsDate()";
		logger.info(methodName+"Called");
		// TODO Auto-generated method stub
		List<Booking> result=bookingRepository.findAllByBookingDate((LocalDate) bookingDate);
		
		if(result.size()==0) {
			throw new BookingNotFoundException("No Bookings Date Found");
		}
		else
		return result;
		}

	/*@Override
	public double calculateTotalCost(int bookingId)throws BookingNotFoundException{
	String methodName="calculateTotalCost()";
     logger.info(methodName+"Called");
		// TODO Auto-generated method stub
		 final double cost=0;
		Optional<Booking> op=bookingRepository.findById(bookingId);
		if(op.isPresent()) {
			Ticket t= op.get().getTicket();
			List<Seat> list=t.getSeat();
			list.forEach(obj->cost+= obj.getPrice());
	}
		else 
			throw new BookingNotFoundException("Booking  not found");
		
		return cost;
}*/
	
}



