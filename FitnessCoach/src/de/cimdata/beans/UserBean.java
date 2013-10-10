package de.cimdata.beans;

import java.io.Serializable;
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
	private User newBuddy;
	private Friends friends;
	private FriendsHome friendshome;
	private int userstate = 2;
	private String tempUsername;
	private String tempPasswort;
	private boolean loggedin;
	private List<User> friendList;
	private List<User> newBuddyList;
	private SelectItem[] selectItems;
	private long userId;
	public UserBean() {
		user = new User();
		newBuddy = new User();
		userhome = new UserHome();
		friends = new Friends();
		friendshome = new FriendsHome();
	}

	public User getUser() {
		return user;
	}

	public UserHome getUserhome() {
		return userhome;
	}

	public User getNewBuddy() {
		return newBuddy;
	}

	public Friends getFriends() {
		return friends;
	}

	public FriendsHome getFriendshome() {
		return friendshome;
	}

	public int getUserstate() {
		return userstate;
	}

	public String getTempUsername() {
		return tempUsername;
	}

	public String getTempPasswort() {
		return tempPasswort;
	}

	public boolean isLoggedin() {
		return loggedin;
	}

	public List<User> getFriendList() {
		friendList = friendshome.findAllFriendsID(this.user.getUserId());
		return friendList;
	}

	public List<User> getNewBuddyList() {
		newBuddyList = friendshome.findAllUserNotFriends(this.user.getUserId());
		return newBuddyList;
	}

	public SelectItem[] getSelectItems() {
		return selectItems;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserhome(UserHome userhome) {
		this.userhome = userhome;
	}

	public void setNewBuddy(User newBuddy) {
		this.newBuddy = newBuddy;
	}

	public void setFriends(Friends friends) {
		this.friends = friends;
	}

	public void setFriendshome(FriendsHome friendshome) {
		this.friendshome = friendshome;
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

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public void setFriendList(List<User> friendList) {
		this.friendList = friendList;
	}

	public void setNewBuddyList(List<User> newBuddyList) {
		this.newBuddyList = newBuddyList;
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
	
	public void changeStatus() {
		userhome.updateStatus(user.getUserId(),user.getStatus());
		//return "profile";
	}
	
	public void changeFitnesslevel() {
		userhome.updateFitnesslevel(user.getUserId(),user.getFitnesslevel());
		//return "profile";
	}
	
	public String saveNewUser() {
		userhome.attachUser(user);
		return "ja";
	}
	
	public String storeNewFriend() {
		System.out.println("------------------------------>storeNewFriend()");
		friendshome.attachNewFriend(createFriendsByIds(user, userId));
		return "friends";
	}
	
	
	public Friends createFriendsByIds(User loggedin, long id) {
		Friends friends = new Friends();
		
		//System.out.println("Buddy: " + buddy.getUsername());
		
		friends.setUserId(loggedin.getUserId());
		friends.setFriendId(id);
		
		return friends;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
