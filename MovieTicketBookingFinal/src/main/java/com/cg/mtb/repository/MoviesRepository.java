package com.cg.mtb.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mtb.entities.Movie;



@Repository("movies")
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
	
	public String  deleteByMovieId(int movieId);
	

	 
	//List<Movie> getAllBymovieDate(LocalDate date);

	
    @Query("select movies from Movie movies join movies.show shows where shows.showStartTime=:starttime")
    public List<Movie> getMovieByDate(@Param("starttime") LocalDate date);
    
    
   // public List<Movie> findAllByTheatreId(int theatreid);
   /* void getMovieByTid(int theatreId);
    @Query("select m from Movie m join m.show s where s.theatre.theatreId = :id")
	public List<Movie> getAllByTheatreId(@Param("id") int id);

   */  
	
}
