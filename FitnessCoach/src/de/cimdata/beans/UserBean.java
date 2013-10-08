package de.cimdata.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	private int kundenStatus;
	private String tempUsername;
	private String tempPasswort;
	
	public UserBean() {
		userhome = new UserHome();
	}
	
	public User getUser() {
		return user;
	}

	public int getKundenStatus() {
		return kundenStatus;
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

	public void setKundenStatus(int kundenStatus) {
		this.kundenStatus = kundenStatus;
	}


	public void setTempUsername(String tempUsername) {
		this.tempUsername = tempUsername;
	}


	public void setTempPasswort(String tempPasswort) {
		this.tempPasswort = tempPasswort;
	}
	
	public String isKundeValid() {
		String antwort = "nein";
		
		tempUsername = user.getUsername();
		tempPasswort = user.getPassword();
		
		user = userhome.findUserByUsernameAndPassword(tempUsername, tempPasswort);
		
		if(user != null) {
			antwort = "ja";
		}
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
		return "neuer Nutzer";
	}
	
}
