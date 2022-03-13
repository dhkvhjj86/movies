package com.cg.mtb.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtb.entities.Theatre;
import com.cg.mtb.exception.TheatreNotFoundByIdException;
import com.cg.mtb.exception.TheatreNotFoundByNameException;
import com.cg.mtb.repository.TheatreRepository;
import com.cg.mtb.service.ITheatreService;
import com.cg.mtb.utilities.GlobalResources;


@Service
	public class TheatreServiceImpl implements ITheatreService {
	
		@Autowired
		private TheatreRepository theatrerepository;
		private Logger logger=GlobalResources.getLogger(TheatreServiceImpl.class);
	    

		@Override
		public List<Theatre> getAllTheatres()  
		{
			String methodName="getAllTheatres()";
			logger.info(methodName+"Called");
          List<Theatre> the = theatrerepository.findAll();
			return the;
			}	
		@Override
		public Theatre getTheatresById(int id) throws TheatreNotFoundByIdException{
			String methodName="getTheatresById()";
			logger.info(methodName+"Called");
			Optional<Theatre> op= theatrerepository.findById(id);
			if(op.isPresent())
			return op.get();
			else
				throw new TheatreNotFoundByIdException("No Theatre found for this id: "+id);
			}
		@Override
		public Theatre getTheatresByName(String tname) throws TheatreNotFoundByNameException{
			String methodName="getTheatresByName()";
			logger.info(methodName+"Called");
			Optional<Theatre> op=theatrerepository.findBytheatreName(tname);
			if(op.isPresent())
			return op.get();
			else 
				throw new TheatreNotFoundByNameException("No Theatre found for this name: "+tname);
		}
		@Override
		public String addTheatres(Theatre theatre)  {
			String methodName="addTheatres()";
			logger.info(methodName+"Called");
			Theatre th=theatrerepository.save(theatre);
			if(!(th==null))	
			return "Inserted Successfully!!!";
			else
			   return "Unable to insert";
		}
		
		@Override
		public String updateTheatres(Theatre name) {
			String methodName="updateTheatres()";
			logger.info(methodName+"Called");
			
			Theatre th=theatrerepository.save(name);
			if(!(th==null))
			return "Updated Successfully!!!";
			else
				return"Unable to update";
		}

		@Override
		public String deleteTheatresById(int theatreId) throws TheatreNotFoundByIdException {
			String methodName="deleteTheatresById()";
			logger.info(methodName+"Called");
			Optional<Theatre> op=theatrerepository.findById(theatreId);
			if(op.isPresent()) {
				theatrerepository.deleteById(theatreId);
				return "Deleted Successfully!!!";
		}
			else
				 throw new TheatreNotFoundByIdException("No Theatre found for this id: "+theatreId);
			  
		}
		
}
