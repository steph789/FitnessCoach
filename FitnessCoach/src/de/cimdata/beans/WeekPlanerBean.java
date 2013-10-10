package de.cimdata.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.cimdata.hibernate.Weekplaner;
import de.cimdata.hibernate.WeekplanerHome;
import de.cimdata.hibernate.Workouts;
import de.cimdata.hibernate.WorkoutsHome;
import de.cimdata.util.FacesHelper;

@SessionScoped
@ManagedBean
public class WeekPlanerBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Workouts workouts;
	private WorkoutsHome workoutshome;
	private Weekplaner weekplaner;
	private WeekplanerHome wph;
	private List<Workouts> listWorkout;
	private UserBean userBean;
	
	public WeekPlanerBean() {
		userBean = (UserBean)FacesHelper.getManagedBean("userBean");
		workouts = new Workouts();
		workoutshome = new WorkoutsHome();
		listWorkout = workoutshome.findAllWorkouts();
	}

	public Workouts getWorkouts() {
		return workouts;
	}

	public WorkoutsHome getWorkoutshome() {
		return workoutshome;
	}

	public Weekplaner getWeekplaner() {
		return weekplaner;
	}

	public WeekplanerHome getWph() {
		return wph;
	}

	public List<Workouts> getListWorkout() {
		return listWorkout;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setWorkouts(Workouts workouts) {
		this.workouts = workouts;
	}

	public void setWorkoutshome(WorkoutsHome workoutshome) {
		this.workoutshome = workoutshome;
	}

	public void setWeekplaner(Weekplaner weekplaner) {
		this.weekplaner = weekplaner;
	}

	public void setWph(WeekplanerHome wph) {
		this.wph = wph;
	}

	public void setListWorkout(List<Workouts> listWorkout) {
		this.listWorkout = listWorkout;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
}
