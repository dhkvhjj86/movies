package com.cg.mtb.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.mtb.entities.Movie;
import com.cg.mtb.exception.MovieIdNotFoundException;


public interface IMoviesService {
public String addMovie(Movie movie);

public String deleteByMovieId (int movieId) throws MovieIdNotFoundException;
	
public String updateMovie(Movie movie);
	
public String addMovieToShow(Movie movie, int showId);

public Movie viewByMovieId(int movieid) throws MovieIdNotFoundException;

public  List<Movie> viewMovieList();

public List<Movie> getMovieByDate(LocalDate date);
}
