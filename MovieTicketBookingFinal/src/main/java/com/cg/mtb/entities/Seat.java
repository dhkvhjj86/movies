package com.cg.mtb.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seatId;
	private int seatNumber;
	private double price;
	@ManyToOne(fetch=FetchType.LAZY)
	private Ticket ticket;
	public Seat() {
		super();
	}
	public Seat(int seatId, int seatNumber, double price) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.price = price;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatNumber=" + seatNumber + ", price=" + price
				+ ", ticket=" + ticket + "]";
	}	
}
