package com.cg.mtb.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Show")
public class Show {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int showId;
private LocalDateTime showStartTime;
private LocalDateTime showEndTime;
private String showName;
private int screenId;
private int theatreId;

//@JsonIgnore
//@OneToOne(fetch=FetchType.LAZY,mappedBy="show")
//private Movie movie;




public Show() {
	
}

public Show(int showId, LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, int screenId,
		int theatreId) {
	super();
	this.showId = showId;
	this.showStartTime = showStartTime;
	this.showEndTime = showEndTime;
	this.showName = showName;
	this.screenId = screenId;
	this.theatreId = theatreId;
	
}

public int getShowId() {
	return showId;
}

public void setShowId(int showId) {
	this.showId = showId;
}

public LocalDateTime getShowStartTime() {
	return showStartTime;
}

public void setShowStartTime(LocalDateTime showStartTime) {
	this.showStartTime = showStartTime;
}

public LocalDateTime getShowEndTime() {
	return showEndTime;
}

public void setShowEndTime(LocalDateTime showEndTime) {
	this.showEndTime = showEndTime;
}

public String getShowName() {
	return showName;
}

public void setShowName(String showName) {
	this.showName = showName;
}

public int getScreenId() {
	return screenId;
}

public void setScreenId(int screenId) {
	this.screenId = screenId;
}

public int getTheatreId() {
	return theatreId;
}

public void setTheatreId(int theatreId) {
	this.theatreId = theatreId;
}



}