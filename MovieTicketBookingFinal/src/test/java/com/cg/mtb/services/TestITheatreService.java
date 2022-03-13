package com.cg.mtb.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.mtb.entities.Theatre;
import com.cg.mtb.exception.TheatreNotFoundByIdException;
import com.cg.mtb.exception.TheatreNotFoundByNameException;
import com.cg.mtb.repository.TheatreRepository;
import com.cg.mtb.serviceImpl.TheatreServiceImpl;


class TestITheatreService {

	@Mock
	TheatreRepository tr;
	@InjectMocks
	TheatreServiceImpl tsi;
	Theatre th;
	
	 

	  @BeforeEach
	  public void init() { 
	      MockitoAnnotations.initMocks(this);
	      th=new Theatre(101,"pvr","hubli", "pranav", 450001234);
	      }
	 
	    @Test
	    void testgetTheatresById() {
	        int id=101;
	        Mockito.when(tr.findById(id)).thenReturn(Optional.of(th));
	       Theatre actualth=tsi.getTheatresById(id);
	        assertEquals(actualth,th);
	        Mockito.verify(tr,Mockito.times(1)).findById(id);
	    }
	    @Test
	    void testgetTheatresByIdFailure()
	    {
	        int id=-101;
	        Mockito.when(tr.findById(id)).thenReturn(Optional.empty());
	        assertThrows(TheatreNotFoundByIdException.class,()->tsi.getTheatresById(id));
	        Mockito.verify(tr,Mockito.times(1)).findById(id);
	    }

	    @Test
	    void testgetAllTheatres()
	    {
	 			  List<Theatre> the=new ArrayList<>();
	 		        the.add(new Theatre(12, "pvr", "hubli", "rahul", 1234567891));
	 		        the.add(new Theatre(102,"apsara","banglore", "sachin", 1234567890));
	 		        the.add(new Theatre(103,"cinepolis","delhi", "gautam", 1234567810));
	 		       
	 		       Mockito.when(tr.findAll()).thenReturn(the);
	 		       assertEquals(the,tsi.getAllTheatres());
	 		       Mockito.verify(tr,Mockito.times(1)).findAll();
	 		}
	    @Test
	    void testgetTheatresByName() {
	      String Name="abcd";
	        Mockito.when(tr.findBytheatreName(Name)).thenReturn(Optional.of(th));
	       Theatre actualth=tsi.getTheatresByName(Name);
	        assertEquals(actualth,th);
	        Mockito.verify(tr,Mockito.times(1)).findBytheatreName(Name);
	    }
	    @Test
	    void testgetTheatresByNameFailure() {
	    	  String Name="-abcd";
		        Mockito.when(tr.findBytheatreName(Name)).thenReturn(Optional.empty());
		        assertThrows(TheatreNotFoundByNameException.class,()->tsi.getTheatresByName( Name));
		        Mockito.verify(tr,Mockito.times(1)).findBytheatreName( Name);
		    }
	    @Test
	    void testaddTheatres() {
	    	Theatre th=new Theatre(106, "abc", "delhi", "kiran", 1234567891);
	    	 Mockito.when(tr.save(th)).thenReturn(th);
	    	 String expectedResult="Inserted Successfully!!!";
	    	 assertEquals(expectedResult, tsi.addTheatres(th));
	    	 Mockito.verify(tr,Mockito.times(1)).save(th);
	    	 
	    }
//	    @Test
//	    void testaddTheatresFailure() throws TheatreNotFoundByNameException{
//	    	Theatre th=new Theatre(-106, "qqq", "Available", "cacv", 1234567391);
//	        Mockito.when(tr.addTheatres(th)).thenReturn(Optional.empty());
//	        String expectedResult="Unable to insert";
//	        //assertThrows(TheatreNotFoundByNameException.class,()->tsi.addTheatres( th));
//	        assertEquals(expectedResult,tsi.addTheatres(th));
//	        Mockito.verify(tr,Mockito.times(1)).addTheatres( th);
//	    }
//	    	
	    
	    

		@Test
		 void testdeleteTheatresById() throws TheatreNotFoundByIdException {
			int id= 101;
			Mockito.when(tr.findById(id)).thenReturn(Optional.of(th));
			String expectedResult="Deleted Successfully!!!";
			assertEquals(expectedResult,tsi.deleteTheatresById(id));
			Mockito.verify(tr,Mockito.times(1)).findById(id);
			
		}
	    
	    @Test
	    void testupdateTheatres() {
	    	Theatre th=new Theatre(27, "theatre", "mysore", "ryan", 1234567123);
	    	 Mockito.when(tr.save(th)).thenReturn(th);
	    	 String expectedResult="Updated Successfully!!!";
	    	 assertEquals(expectedResult, tsi.updateTheatres(th));
	    	 Mockito.verify(tr,Mockito.times(1)).save(th);
	    	 
	    }
//	    @Test
//	    void testupdateTheatresFailure() {
//	    	String Name="-abcd";
//	        Mockito.when(tr.updateTheatres(Name)).thenReturn(Optional.empty());
//	        assertThrows(TheatreNotFoundByNameException.class,()->tsi.updateTheatres(Name));
//	        Mockito.verify(tr,Mockito.times(1)).updateTheatres( Name);
//	    	
//    }
//	   
	}






