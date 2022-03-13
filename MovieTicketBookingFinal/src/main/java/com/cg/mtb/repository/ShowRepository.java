package com.cg.mtb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mtb.entities.Show;


@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
	
	//List<Show> findAllByTheatreId(@Param("theatreId") int theatreId);

}
