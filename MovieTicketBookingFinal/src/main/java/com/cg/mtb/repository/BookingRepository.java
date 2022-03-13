package com.cg.mtb.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtb.entities.Booking;

@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking,Integer> {
	
	
	List<Booking> findAllByMovieId(int movieid);
	List<Booking> findAllByBookingDate(LocalDate bookingDate);
	List<Booking> findAllByShowId(int showId);

}
