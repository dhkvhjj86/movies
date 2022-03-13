package com.cg.mtb.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Min(value=0,message="bookingId cannot be zero or negative")
	private int bookingId;
	private int movieId;
	private int showId;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	//@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-MM-dd")
	//@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingDate;
	private double totalCost;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="booking")
	private Ticket ticket;
	
	public Booking() {
		super();
	}
	
	public Booking(int bookingId, int movieId, int showId, LocalDate bookingDate, double totalCost, Ticket ticket) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showId = showId;
		this.bookingDate = bookingDate;
		this.totalCost = totalCost;
		this.ticket = ticket;
	}
	
	public LocalDate getBookingDate() {
		// TODO Auto-generated method stub
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate=bookingDate;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", movieId=" + movieId + ", showId=" + showId + ", bookingDate="
				+ bookingDate + ", totalCost=" + totalCost + ", ticket=" + ticket + "]";
	}
}
