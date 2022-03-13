package com.cg.mtb.service;

import java.util.List;

import com.cg.mtb.entities.Theatre;
import com.cg.mtb.exception.TheatreNotFoundByIdException;
import com.cg.mtb.exception.TheatreNotFoundByNameException;


public interface ITheatreService {
	public List<Theatre> getAllTheatres();
	public String addTheatres(Theatre theatre);
	public String updateTheatres(Theatre name);
	public String deleteTheatresById(int id)throws TheatreNotFoundByIdException;
	public Theatre getTheatresById(int id)throws TheatreNotFoundByIdException;
	public Theatre getTheatresByName(String tname)throws TheatreNotFoundByNameException;
}
