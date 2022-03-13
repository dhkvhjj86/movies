package com.cg.mtb.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtb.entities.Screen;
import com.cg.mtb.exception.ScreenNotFoundByIdException;
import com.cg.mtb.exception.ScreenNotFoundByNameException;
import com.cg.mtb.repository.ScreenRepository;
import com.cg.mtb.service.IScreenservices;



	@Service
	public class ScreenserviceImpl implements IScreenservices {
	
		@Autowired
		private ScreenRepository screenrepository;
		//private Logger logger=GlobalResources.getLogger(ScreenserviceImpl.class);
	    

		@Override
		public List<Screen>  getAllScreens()  
		{
			//String methodName="getAllTheatres()";
			//logger.info(methodName+"Called");
          List<Screen> the = screenrepository.findAll();
			return the;
			}	
		@Override
		public Screen getScreenById(int id) throws  ScreenNotFoundByIdException{
			//String methodName="getScreenById()";
			//logger.info(methodName+"Called");
			Optional<Screen> op= screenrepository.findById(id);
			if(op.isPresent())
			return op.get();
			else
				throw new  ScreenNotFoundByIdException("No Screen found for this id: "+id);
			}
		@Override
		public Screen getScreenByName(String tname) throws ScreenNotFoundByNameException {
			//String methodName="getTheatresByName()";
			//logger.info(methodName+"Called");
			Optional<Screen> op=screenrepository.findByScreenName(tname);
			if(op.isPresent())
			return op.get();
			else 
				throw new ScreenNotFoundByNameException("No screen found for this name: "+tname);
		}
		@Override
		public String addScreen(Screen screen)  {
			//String methodName="addTheatres()";
			//logger.info(methodName+"Called");
			Screen s=screenrepository.save(screen);
			if(!(s==null))	
			return "Inserted Successfully!!!";
			else
			   return "Unable to insert";
		}
		
		@Override
		public String updateScreen(Screen name) {
			//String methodName="updateTheatres()";
			//logger.info(methodName+"Called");
			
			Screen s=screenrepository.save(name);
			if(!(s==null))
			return "Updated Successfully!!!";
			else
				return"Unable to update";
		}

		@Override
		public String deleteScreenById(int id) throws  ScreenNotFoundByIdException {
			//String methodName="deleteTheatresById()";
			//logger.info(methodName+"Called");
			Optional<Screen> op=screenrepository.findById(id);
			if(op.isPresent()) {
				screenrepository.deleteById(id);
				return "Deleted Successfully!!!";
		}
			else
				 throw new  ScreenNotFoundByIdException("No Screen found for this id: "+id);
			  
		}
		

}
