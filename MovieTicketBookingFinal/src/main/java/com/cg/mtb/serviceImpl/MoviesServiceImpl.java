package com.cg.mtb.serviceImpl;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtb.entities.Movie;
import com.cg.mtb.exception.MovieIdNotFoundException;
import com.cg.mtb.repository.MoviesRepository;
import com.cg.mtb.repository.ShowRepository;
import com.cg.mtb.service.IMoviesService;
import com.cg.mtb.utilities.GlobalResources;



@Service("MoviesService")
public class MoviesServiceImpl implements IMoviesService {
	
	@Autowired
	private MoviesRepository movies;
	@Autowired
	private ShowRepository shows;
	private Logger logger=GlobalResources.getLogger(MoviesServiceImpl.class);


	@Override
	public String addMovie(Movie movie){
		String methodName="addMovie()";
		logger.info(methodName+"Called");
		movies.save(movie);
		return "Inserted Successfully";
		}

	@Override
	public String deleteByMovieId (int movieId) throws MovieIdNotFoundException {
		String methodName="deleteByMovieId()";
		logger.info(methodName+"Called");
	Optional<Movie> mov=movies.findById(movieId);
	if(mov.isPresent()) {
		 movies.deleteById(movieId);
	return "Deleted successfully";
	}
	else
		throw new MovieIdNotFoundException("MovieId not found");
	}

	@Override
	public String updateMovie(Movie movie){
	String methodName="updateMovie()";
	logger.info(methodName+"Called");
	movies.save(movie);
	return "updated Successfully";
	}

	@Override
	public String addMovieToShow(Movie movie, int showId){
		return null;
		
	}	
	

	@Override
	public Movie viewByMovieId(int movieid) throws MovieIdNotFoundException {
	String methodName="viewByMovieId()";
	logger.info(methodName+"Called");
	Optional<Movie> mov=movies.findById(movieid);
	if(mov.isPresent())
		return mov.get();
	else
		throw new MovieIdNotFoundException("MovieId not Found");
	
	
	}

	@Override
	public List<Movie> viewMovieList(){
	String methodName="viewMovieList()";
	logger.info(methodName+"Called");
		return  movies.findAll();
		
	}

	@Override
	public List<Movie>getMovieByDate(LocalDate date) {
	String methodName="getMovieByDate";
	logger.info(methodName+"Called");
	
	
	List<Movie> mov=movies.getMovieByDate((LocalDate) date);
	return mov;
	
	 
		
	}

	/*@Override
	public List<Movie> findAllByTheatreId(int theatreid) {
	
		//List<Show> sho=shows.findAllByTheatreId(theatreid);
		
		
		return null;
	
	} */
	
	

	

		
	}

	
	
	
		
