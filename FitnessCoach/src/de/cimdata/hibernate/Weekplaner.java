package de.cimdata.hibernate;

import java.io.Serializable;

public class Weekplaner implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long planId;
	private Long userId;
	private Long monday;
	private Long tuesday;
	private Long wednesday;
	private Long thursday;
	private Long friday;
	private Long saturday;
	private Long sunday;
	
	public Weekplaner() {}
	
	public Weekplaner(Long planId, Long userId, Long monday, Long tuesday,
			Long wednesday, Long thursday, Long friday, Long saturday,
			Long sunday) {
		this.planId = planId;
		this.userId = userId;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}
	

	public Long getPlanId() {
		return planId;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getMonday() {
		return monday;
	}

	public Long getTuesday() {
		return tuesday;
	}

	public Long getWednesday() {
		return wednesday;
	}

	public Long getThursday() {
		return thursday;
	}

	public Long getFriday() {
		return friday;
	}

	public Long getSaturday() {
		return saturday;
	}

	public Long getSunday() {
		return sunday;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setMonday(Long monday) {
		this.monday = monday;
	}

	public void setTuesday(Long tuesday) {
		this.tuesday = tuesday;
	}

	public void setWednesday(Long wednesday) {
		this.wednesday = wednesday;
	}

	public void setThursday(Long thursday) {
		this.thursday = thursday;
	}

	public void setFriday(Long friday) {
		this.friday = friday;
	}

	public void setSaturday(Long saturday) {
		this.saturday = saturday;
	}

	public void setSunday(Long sunday) {
		this.sunday = sunday;
	}
	
}
