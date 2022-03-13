package com.cg.mtb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtb.entities.Screen;

@Repository
public interface ScreenRepository  extends JpaRepository <Screen, Integer> {

	Optional<Screen> findByScreenName(String tname);

	
	
}
