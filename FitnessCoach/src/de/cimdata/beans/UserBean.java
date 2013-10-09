package de.cimdata.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import de.cimdata.hibernate.Friends;
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
	private Friends friends;
	private FriendsHome friendshome;
	private int userstate = 2;
	private String tempUsername;
	private String tempPasswort;
	private boolean loggedin;
	private List<User> friendList;
	private SelectItem[] selectItems;
	
	public UserBean() {
		user = new User();
		userhome = new UserHome();
		friends = new Friends();
		friendshome = new FriendsHome();
	}
	
	public SelectItem[] getUsersForFriends(List<User> friendList) {
		int z = friendList.size();
		List<SelectItem> selects = new ArrayList<>();
		for(int i = 0; i < friendList.size(); i++) {
			SelectItem item = new SelectItem(friendList.get(i).getUserId(), friendList.get(i).getUsername());
			selects.add(item);
		}
		
		SelectItem[] items = (SelectItem[]) selects.toArray();
        return items;
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

	public List<User> getFriendList() {
		friendList = friendshome.findAllFriendsID(this.user.getUserId());
		return friendList;
	}

	public void setFriendList(List<User> friendList) {
		this.friendList = friendList;
	}

	public SelectItem[] getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(SelectItem[] selectItems) {
		this.selectItems = selectItems;
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
		return "profile";
	}
	
	public String changeLastname() {
		userhome.updateLastname(user.getUserId(),user.getLastname());
		return "profile";
	}
	
	public String changeEmail() {
		userhome.updateEmail(user.getUserId(),user.getEmail());
		return "profile";
	}
	
	public String changeRun() {
		userhome.updateRun(user.getUserId(),user.getRun());
		return "profile";
	}
	
	public String changeBike() {
		userhome.updateBike(user.getUserId(),user.getBike());
		return "profile";
	}
	public String changeSwim() {
		userhome.updateSwim(user.getUserId(),user.getSwim());
		return "profile";
	}
	public String changePump() {
		userhome.updatePump(user.getUserId(),user.getPump());
		return "profile";
	}
	
	public String changeStatus() {
		userhome.updateStatus(user.getUserId(),user.getStatus());
		return "profile";
	}
	
	public String changeFitnesslevel() {
		userhome.updateFitnesslevel(user.getUserId(),user.getFitnesslevel());
		return "profile";
	}
	
	public String saveNewUser() {
		userhome.attachUser(user);
		return "ja";
	}
	
	public String storeNewFriend() {
		friendshome.attachNewFriend(friends);
		return "friends";
	}
	

}
