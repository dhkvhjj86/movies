package com.cg.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtb.entities.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
