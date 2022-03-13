package com.cg.mtb.service;

import java.util.List;

import com.cg.mtb.entities.Screen;
import com.cg.mtb.exception.ScreenNotFoundByIdException;
import com.cg.mtb.exception.ScreenNotFoundByNameException;


public interface IScreenservices {
	public List<Screen> getAllScreens();
	public String addScreen(Screen screen);
	public String updateScreen(Screen name);
	public String deleteScreenById(int id)throws ScreenNotFoundByIdException;
	public Screen getScreenById(int id)throws ScreenNotFoundByIdException;
	public Screen getScreenByName(String tname)throws ScreenNotFoundByNameException;

}
