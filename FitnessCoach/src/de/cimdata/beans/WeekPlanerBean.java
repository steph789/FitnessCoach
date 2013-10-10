package de.cimdata.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

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
	private List<Workouts> droppedWorkoutMo;
	private UserBean userBean;
	
	public WeekPlanerBean() {
		userBean = (UserBean)FacesHelper.getManagedBean("userBean");
		workouts = new Workouts();
		workoutshome = new WorkoutsHome();
		listWorkout = workoutshome.findAllWorkouts();
		droppedWorkoutMo = new ArrayList<Workouts>();
	}
	
	public void onWorkoutDrop(DragDropEvent ddEvent) {  
        Workouts w = ((Workouts) ddEvent.getData());  
        droppedWorkoutMo.add(w);  
        listWorkout.remove(w);  
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

	public List<Workouts> getDroppedWorkoutMo() {
		return droppedWorkoutMo;
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

	public void setDroppedWorkoutMo(List<Workouts> droppedWorkoutMo) {
		this.droppedWorkoutMo = droppedWorkoutMo;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	
}
