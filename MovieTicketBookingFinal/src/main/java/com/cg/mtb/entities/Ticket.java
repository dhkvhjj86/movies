package com.cg.mtb.entities;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Ticket {
	private static final String CascadedType = null;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	private int noOfSeats;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Booking booking;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="ticket")
	private List<Seat> seat;
	
	public List<Seat> getSeat() {
		return seat;
	}
	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}
	public Ticket() {
		super();
	}
	public Ticket(int ticketId, int noOfSeats) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		
		
	}
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	
	
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats +   "]";
	}
		
}
