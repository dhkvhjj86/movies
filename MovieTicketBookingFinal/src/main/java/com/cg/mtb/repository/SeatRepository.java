package com.cg.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtb.entities.Seat;


@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer>{

}
