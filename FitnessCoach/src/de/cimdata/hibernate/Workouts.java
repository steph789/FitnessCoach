package de.cimdata.hibernate;

import java.io.Serializable;

public class Workouts implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long wId;
	private String name;
	private String sport;
	private int fierce;
	private int time;
	
	public Workouts() {}
	
	public Workouts(Long wId, String name, String sport, int fierce, int time) {
		this.wId = wId;
		this.name = name;
		this.sport = sport;
		this.fierce = fierce;
		this.time = time;
	}

	public Long getwId() {
		return wId;
	}

	public String getName() {
		return name;
	}

	public String getSport() {
		return sport;
	}

	public int getFierce() {
		return fierce;
	}

	public int getTime() {
		return time;
	}

	public void setwId(Long wId) {
		this.wId = wId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setFierce(int fierce) {
		this.fierce = fierce;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
