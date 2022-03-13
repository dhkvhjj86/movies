package com.cg.mtb.services;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.mtb.entities.Movie;
import com.cg.mtb.entities.Show;
import com.cg.mtb.exception.MovieIdNotFoundException;
import com.cg.mtb.repository.MoviesRepository;
import com.cg.mtb.serviceImpl.MoviesServiceImpl;


class TestMovieService {

	@Mock
	MoviesRepository mr;
	@InjectMocks
	MoviesServiceImpl mri;
	Movie mov;
	 

	 
	@BeforeEach
	  public void init() { 
	      MockitoAnnotations.initMocks(this);
	      DateTimeFormatter formatter
          = DateTimeFormatter.ofPattern(
              "yyyy-MM-dd HH:mm:ss a");
	      LocalDateTime now = LocalDateTime.now();
	      
	   mov=new Movie(101, "kgf", "horror", "1", "kannada", "description ",new Show(1,now,now,"first show ",1,1));
	      //(int movieId, String movieName, String movieGenre, String movieHours, String language,
			//String description, Show show)
	      //int showId, LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, int screenId,
			//int theatreId, Movie movie
	      }
	 
	    @Test
	    void testviewByMovieId() {
	        int movieId=101;
	        Mockito.when(mr.findById(movieId)).thenReturn(Optional.of(mov));
	       Movie actualmov=mri.viewByMovieId(movieId);
	        assertEquals(actualmov,mov);
	        Mockito.verify(mr,Mockito.times(1)).findById(movieId);
	    }
	    @Test
	    void testviewByMovieIdFailure()
	    {
	        int movieId=-101;
	        Mockito.when(mr.findById(movieId)).thenReturn(Optional.empty());
	        assertThrows(MovieIdNotFoundException.class,()->mri.viewByMovieId(movieId));
	        Mockito.verify(mr,Mockito.times(1)).findById(movieId);
	    }
	    
	    @Test
	    void testaddMovie() {
	    	
	    	 Mockito.when(mr.save(mov)).thenReturn(mov);
	    //	 String actualResult=vsi.addVaccine(v);
	    	 String expectedResult="Inserted Successfully";
	    	 assertEquals(expectedResult, mri.addMovie(mov));
	    	 Mockito.verify(mr,Mockito.times(1)).save(mov);
	    	 
	    }
	    
	    @Test
		public void testupdateMovie(){
			Mockito.when(mr.save(mov)).thenReturn(mov);
			String expectedResult="updated Successfully";
			assertEquals(expectedResult,mri.updateMovie(mov));
			Mockito.verify(mr,Mockito.times(1)).save(mov);
		}
	    
	    @Test
	    void testdeleteByMovieId()
	    {
	        int movieId=101;
	        Mockito.when(mr.findById(movieId)).thenReturn(Optional.of(mov));
	        String expectedResult="Deleted successfully";
	        assertEquals(expectedResult,mri.deleteByMovieId(movieId));
	        Mockito.verify(mr,Mockito.times(1)).deleteByMovieId(movieId);
	    }
	    
	    @Test
	    void testdeleteByMovieIdFailure()
	    {
	        int movieId=-101;
	        Mockito.when(mr.findById(movieId)).thenReturn(Optional.empty());
	        assertThrows(MovieIdNotFoundException.class,()->mri.deleteByMovieId(movieId));
	        Mockito.verify(mr,Mockito.times(1)).deleteByMovieId(movieId);
	    }
	    
	    
	    
	    
	    
	  
}
