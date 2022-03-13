package com.cg.mtb.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.mtb.ResponseInfo.ResponseInfo;
import com.cg.mtb.entities.Movie;
import com.cg.mtb.entities.Screen;
import com.cg.mtb.entities.Theatre;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
	
	@Autowired
	RestTemplate rt;
	
	String endPoint1 = "http://localhost:8084/movies";
	String endPoint2 = "http://localhost:8084/theatres";
	String endPoint3 = "http://localhost:8084/screens";
	
	
	@GetMapping("/admins/movies")
	List<Movie> getMovies(){
			List<Movie> list = Arrays.asList(rt.getForObject(endPoint1, Movie[].class));
			return list;
		}

	@GetMapping("/admins/screens")
	List<Screen> getScreen() {
		List<Screen> list = Arrays.asList(rt.getForObject(endPoint3, Screen[].class));
		return list;

	}
	@GetMapping("/admins/theatres")
	List<Theatre> getTheater() {
		List<Theatre> list = Arrays.asList(rt.getForObject(endPoint2, Theatre[].class));
		return list;

	}
	@PostMapping("/admins/movies")
		ResponseEntity<ResponseInfo> insertMovie(@RequestBody Movie movie) {
			return rt.postForEntity(endPoint1, movie, ResponseInfo.class);
	}

	@PostMapping("/admins/screens")
	ResponseEntity<ResponseInfo> insertScreen(@RequestBody Screen screen) {
		return rt.postForEntity(endPoint3, screen, ResponseInfo.class);
	}


	@PostMapping("/admins/theatres")
	ResponseEntity<ResponseInfo> insertTheater(@RequestBody Theatre theatre) {
		return rt.postForEntity(endPoint2, theatre, ResponseInfo.class);

	}

	@PutMapping("/admins/movies")
	ResponseEntity<ResponseInfo> updateMovie(@RequestBody Movie movie) {
		return rt.postForEntity(endPoint1, movie, ResponseInfo.class);


	}
	@PutMapping("/admins/screens")
	ResponseEntity<ResponseInfo> updateScreen(@RequestBody Screen name) {
		return rt.postForEntity(endPoint3, name, ResponseInfo.class);
		

	}

	@PutMapping("/admins/theatres")
	ResponseEntity<ResponseInfo> updateMovie(@RequestBody Theatre theatre) {
		return rt.postForEntity(endPoint2, theatre, ResponseInfo.class);

	}

	@DeleteMapping("/admins/movies/{movieId}")
	String deleteMovie(@PathVariable("movieId") int id) {
		rt.delete(endPoint1 + "/" + id);
		return "Deleted Successfully";
		}

		@DeleteMapping("/admins/screens/{id}")
		String deleteScreen(@PathVariable("name") int id) {
			rt.delete(endPoint3 + "/" + id);
			return "Deleted Successfully";
		}

		@DeleteMapping("/admins/theatres/{id}")
		String deleteTheatre(@PathVariable("id") int id) {

			rt.delete(endPoint2+ "/" + id);
			return "Deleted Successfully";

		}
		
	}
