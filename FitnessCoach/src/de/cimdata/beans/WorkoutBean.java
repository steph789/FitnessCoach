package de.cimdata.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.cimdata.data.Workout;

@SessionScoped
@ManagedBean
public class WorkoutBean implements Serializable{
	
	private Workout workout = new Workout();

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	
	

}
