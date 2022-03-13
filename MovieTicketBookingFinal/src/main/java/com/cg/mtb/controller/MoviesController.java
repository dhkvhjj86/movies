package com.cg.mtb.controller;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtb.ResponseInfo.ResponseInfo;
import com.cg.mtb.entities.Movie;
import com.cg.mtb.exception.MovieIdNotFoundException;
import com.cg.mtb.service.IMoviesService;
import com.cg.mtb.serviceImpl.MoviesServiceImpl;
import com.cg.mtb.utilities.GlobalResources;


@RestController
public class MoviesController{
 @Autowired
 IMoviesService MoviesService;
 private Logger logger=GlobalResources.getLogger(MoviesServiceImpl.class);
@GetMapping("/movies")
public List<Movie> viewMovieList(){
	String methodName="viewMovieList()";
	logger.info(methodName+"Called");
	
	return MoviesService.viewMovieList();
}
	
@PostMapping("/movies")
ResponseEntity<ResponseInfo> insertMovie(@RequestBody Movie movie,HttpServletRequest request)
    {   String methodName="addMovie()";
	    logger.info(methodName+"Called");
        String msg = MoviesService.addMovie(movie);
        ResponseInfo rinfo= new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
        ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
        return rentity;

    }
@PutMapping("/movies")
ResponseEntity<ResponseInfo> updateMovie(@RequestBody Movie movie,HttpServletRequest request)
{    String methodName=" updateMovie";
     logger.info(methodName+"Called");
	 String msg = MoviesService.updateMovie(movie);
	 ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
     ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
     return rentity;

}

@DeleteMapping("/movies/{movieId}")
ResponseEntity<ResponseInfo> deleteByMovieId(@PathVariable("movieId") int movieId, HttpServletRequest request)throws MovieIdNotFoundException{
	 String methodName="deleteByMovieId";
     logger.info(methodName+"Called");
	String msg=MoviesService.deleteByMovieId(movieId);
    ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
    ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
    return rentity;
}

@GetMapping("/movies/{movieid}")
Movie viewMovieById (@PathVariable("movieid") int movieid) throws MovieIdNotFoundException {
	 String methodName="viewMovieById";
     logger.info(methodName+"Called");
	Movie msg=MoviesService.viewByMovieId(movieid);
	return msg;
	
}

@GetMapping("/movies/ByDate/date")
	public List<Movie> getMovieByDate(
			@RequestParam("movieDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
	 String methodName="getMovieByDate";
     logger.info(methodName+"Called");
		
		return MoviesService.getMovieByDate(date);
	}
/*@GetMapping("/movies/byTheatreId/{theatreId}")
		public List<Movie> getAllByTheatreId(int theatreid){
			return null;
	    
			
			
		} */

	
}
 
	







/**

@RestController
@RequestMapping("/movies")
public class MoviesController {

	
	@Autowired
	private MoviesService moviesService;

	
	@PostMapping("/add")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie)
			throws MovieNotFoundException, IOException {
		movie = moviesService.addMovie(movie);
		
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}

	
	@PutMapping("/update")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie)
			throws MovieNotFoundException {

		ResponseEntity<Movie> response = null;
		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			movie = moviesService.updateMovie(movie);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			
		}
		return response;
	}
	
	@PutMapping("/map")
	public ResponseEntity<Movie> addToShow(@RequestBody Movie movie,@RequestParam(required = false) Integer showId)
			throws MovieNotFoundException {

		ResponseEntity<Movie> response = null;
		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			movie = moviesService.addMovieToShow(movie,showId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			
		}
		return response;
	}

	
	
	
	
	@GetMapping("/findall")
	public ResponseEntity<List<Movie>> viewMovieList() throws MovieNotFoundException {

		
		return ResponseEntity.ok(moviesService.viewMovieList());
	}

	@GetMapping("/viewMovie/{movieId}")
	public ResponseEntity<Movie> viewMovie(@PathVariable int movieId)
			throws MovieNotFoundException {

		ResponseEntity<Movie> response = null;
		try {
			Movie movie = moviesService.viewMovie(movieId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new MovieNotFoundException("Movie with " + movieId + " id dosen't exist");
		}
		return response;
		// return ResponseEntity.ok(moviesService.viewMovie(movieId));
	}

	
	@DeleteMapping("/delete/{movieId}")
	public ResponseEntity<Movie> removeMovie(@PathVariable int movieId)
			throws MovieNotFoundException {

		ResponseEntity<Movie> response = null;
		Movie movie = moviesService.viewMovie(movieId);
		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			moviesService.deleteByMovieId(movieId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			
		}
		return response;
	}

	
 /**   @GetMapping("/byTheatre/{theatreId}")
	public List<Movie> viewMovieByTheatreId(@PathVariable int theatreId)  {
		
		return moviesService.viewMovieList(theatreId);
	}


	
	@GetMapping("/byDate/{date}")
	public List<Movie> getAllBymovieDate(
			@RequestParam("movieDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		
		return moviesService.viewMovieList(date);
	}

}


*/







