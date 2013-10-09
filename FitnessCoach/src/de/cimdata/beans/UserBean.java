package de.cimdata.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.cimdata.hibernate.FriendsHome;
import de.cimdata.hibernate.User;
import de.cimdata.hibernate.UserHome;

@SessionScoped
@ManagedBean
public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserHome userhome;
	private FriendsHome friendshome;
	private int userstate = 2;
	private String tempUsername;
	private String tempPasswort;
	private boolean loggedin;
	private List<User> friends;
	
	public UserBean() {
		user = new User();
		userhome = new UserHome();
		friendshome = new FriendsHome();
		//friends = friendshome.findAllFriendsID(user.getUserId());
	}
	
	public User getUser() {
		return user;
	}

	public String getTempUsername() {
		return tempUsername;
	}

	public String getTempPasswort() {
		return tempPasswort;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public int getUserstate() {
		return userstate;
	}

	public void setUserstate(int userstate) {
		this.userstate = userstate;
	}

	public void setTempUsername(String tempUsername) {
		this.tempUsername = tempUsername;
	}


	public void setTempPasswort(String tempPasswort) {
		this.tempPasswort = tempPasswort;
	}
	
	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public String isUserValid() {
		String antwort = "nein";
		

		
		user = userhome.findUserByUsernameAndPassword(tempUsername, tempPasswort);
		
		System.out.println("UserBean: User->"+user);
		
		if(user != null) {
			antwort = "ja";
			this.loggedin = true;
			
		}
		System.out.println(loggedin);
		
		return antwort;
	}


	public String changeFirstname() {
		userhome.updateFirstname(user.getUserId(),user.getFirstname());
		return "neuer Vorname";
	}
	
	public String changeLastname() {
		userhome.updateLastname(user.getUserId(),user.getLastname());
		return "neuer Nachname";
	}
	
	public String changeEmail() {
		userhome.updateEmail(user.getUserId(),user.getEmail());
		return "neue E-Mail";
	}
	
	public String changeRun() {
		userhome.updateRun(user.getUserId(),user.getRun());
		return "laufen";
	}
	
	public String changeBike() {
		userhome.updateBike(user.getUserId(),user.getBike());
		return "radfahren";
	}
	public String changeSwim() {
		userhome.updateSwim(user.getUserId(),user.getSwim());
		return "schwimmen";
	}
	public String changePump() {
		userhome.updatePump(user.getUserId(),user.getPump());
		return "bodypump";
	}
	
	public String changeStatus() {
		userhome.updateStatus(user.getUserId(),user.getStatus());
		return "neuer Status";
	}
	
	public String changeFitnesslevel() {
		userhome.updateFitnesslevel(user.getUserId(),user.getFitnesslevel());
		return "neues Fitnesslevel";
	}
	
	public String saveNewUser() {
		userhome.attachUser(user);
		return "ja";
	}
	

}
