package com.cg.mtb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtb.entities.Theatre;

@Repository
public interface TheatreRepository  extends JpaRepository <Theatre, Integer> {

	Optional<Theatre> findBytheatreName(String tname);

	
	
}
