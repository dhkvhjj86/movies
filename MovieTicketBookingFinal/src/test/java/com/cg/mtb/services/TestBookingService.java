package com.cg.mtb.services;
	import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.MockitoAnnotations;
	import org.mockito.junit.MockitoJUnitRunner;
	import org.springframework.web.bind.MethodArgumentNotValidException;

import com.cg.mtb.entities.Booking;
import com.cg.mtb.entities.Seat;
import com.cg.mtb.entities.Ticket;
import com.cg.mtb.exception.BookingNotFoundException;
import com.cg.mtb.repository.BookingRepository;
import com.cg.mtb.serviceImpl.BookingServiceImpl;


	class TestBookingService {
	@Mock
	BookingRepository br;
	@InjectMocks
	BookingServiceImpl bookingService;
	Booking bk;
	Ticket tk;
	Seat sk;
	
	  @BeforeEach
	  public void init() { 
	      MockitoAnnotations.initMocks(this);
	      bk=new Booking(1,11,3,LocalDate.of(2022, 03, 10), 100.25, tk);
	      tk=new Ticket(2, 3);
	      sk=new Seat(21,22, 200.5);
	      }
	  
	  
	  @Test
		public void testAddBooking() {
		 	
			Mockito.when(br.save(bk)).thenReturn(bk);
			//String actualResult=service.addBooking(m);
			String expectedResult="Booking Added Successfully";
			assertEquals(expectedResult,bookingService.addBooking(bk));
			Mockito.verify(br,Mockito.times(1)).save(bk);
		}
	  
	 @Test
	 void testDeleteBooking() throws BookingNotFoundException {
	 int bookingId=1;
	 Mockito.when(br.findById(bookingId)).thenReturn(Optional.of(bk));
	 String excpectedResult="Deleted Successfully!!";
	 //String actualResult=service.cancelCustomer(id);
	 assertEquals(excpectedResult, bookingService.deleteBooking(bookingId));
	 Mockito.verify(br, Mockito.times(1)).findById(bookingId);
	 }
	 
		@Test
		public void testUpdateBooking() throws BookingNotFoundException {
			
			Mockito.when(br.save(bk)).thenReturn(bk);
			String expectedResult="Booking Updated";
			assertEquals(expectedResult,bookingService.updateBooking(bk));
			Mockito.verify(br,Mockito.times(1)).save(bk);
		}
		
	    
	    @Test
	    void testShowBookingList() throws BookingNotFoundException
	    {
	        int showId=11;
	        List<Booking> bk=new ArrayList<>();
	        bk.add(new Booking(11,12,13, LocalDate.of(2022, 02, 22),0.0,tk));
	        bk.add(new Booking(41,42,43, LocalDate.of(2022, 01, 22),0.0,tk));
	        Mockito.when(br.findAllByShowId(showId)).thenReturn(bk);
	        assertEquals(bookingService.showBookingList(showId), bk);
	        Mockito.verify(br,Mockito.times(1)).findAllByShowId(showId);
	    }
	    @Test
	    void testShowBookingListFailure()
	    {
	        int showId=0;
	        List<Booking> bk=new ArrayList<>();
	        Mockito.when(br.findAllByShowId(showId)).thenReturn(List.of());
	        assertThrows(BookingNotFoundException.class,()->bookingService.showBookingList(showId));
	        Mockito.verify(br,Mockito.times(1)).findAllByShowId(showId);
	    }
	    
	    
	    @Test
	    void testShowAllBookings() throws BookingNotFoundException
	    {
	        int movieId=11;
	    
	        List<Booking> bk=new ArrayList<>();
	        bk.add(new Booking(31,11,43, LocalDate.of(2022, 01, 22),0.0,tk)); 
	        bk.add(new Booking(41,42,43, LocalDate.of(2022, 01, 22),0.0,tk));
	        
	        Mockito.when(br.findAllByMovieId(movieId)).thenReturn(bk);
	        assertEquals(bookingService.showAllBookings(movieId), bk);	        
	        Mockito.verify(br,Mockito.times(1)).findAllByMovieId(movieId);
	    }
	    @Test
	    void testShowAllBookingsFailure()
	    {
	        int movieId=-1;
	        List<Booking> bk=new ArrayList<>();
	        Mockito.when(br.findAllByMovieId(movieId)).thenReturn(List.of());	        
	        assertThrows(BookingNotFoundException.class,()->bookingService.showAllBookings(movieId));
	        Mockito.verify(br,Mockito.times(1)).findAllByMovieId(movieId);
	    }
	    
	    
	   @Test
	    void  testshowAllBookingsDate() throws BookingNotFoundException
	    {
	        LocalDate bookingDate=LocalDate.of(2020, 02, 01);
	    
	        List<Booking> bk=new ArrayList<>();
	        bk.add(new Booking(11,12,13, LocalDate.of(2022, 02, 01),0.0,tk));
	        bk.add(new Booking(41,42,43, LocalDate.of(2022, 01, 22),0.0,tk));
	        
	        Mockito.when(br.findAllByBookingDate(bookingDate)).thenReturn(bk);
	        assertEquals(bookingService.showAllBookingsDate(bookingDate), bk);	        
	        Mockito.verify(br,Mockito.times(1)).findAllByBookingDate(bookingDate);
	    }
	    @Test
	    void testShowAllBookingsDateFailure()
	    {
	        LocalDate bookingDate=LocalDate.of(2012, 02, 01);
	       // List<Booking> bk=new ArrayList<>();
	        Mockito.when(br.findAllByBookingDate(bookingDate)).thenReturn(List.of());  
	        assertThrows(BookingNotFoundException.class,()->bookingService.showAllBookingsDate(bookingDate));
	        Mockito.verify(br,Mockito.times(1)).findAllByBookingDate(bookingDate);
	    }
	    
	    
	  /*  @Test
	    void  testcalculateTotalCost() throws BookingNotFoundException
	    {
	        int bookingId=1;
	        Mockito.when(br.findById(bookingId)).thenReturn(Optional.of(bk));
	        assertEquals(bookingService.calculateTotalCost(bookingId), bk);
	        Mockito.verify(br,Mockito.times(1)).findById(bookingId);
	    }
	    @Test
	    void testcalculateTotalCostFailure()
	    {
	       int bookingId=-1;
	        Mockito.when(br.findById(bookingId)).thenReturn(Optional.empty());
	        assertThrows(BookingNotFoundException.class,()->bookingService.calculateTotalCost(bookingId));
	        Mockito.verify(br,Mockito.times(1)).findById(bookingId);
	    }*/
	    
	    
	}
	
