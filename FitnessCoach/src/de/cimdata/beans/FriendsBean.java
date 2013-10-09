package de.cimdata.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.cimdata.hibernate.Friends;
import de.cimdata.hibernate.FriendsHome;


@ManagedBean
@SessionScoped
public class FriendsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Friends friends;
	private FriendsHome friendshome;
	
	public FriendsBean() {
		friends = new Friends();
		friendshome = new FriendsHome();
	}

	public Friends getFriends() {
		return friends;
	}

	public void setFriends(Friends friends) {
		this.friends = friends;
	}
	
	public FriendsHome getFriendshome() {
		return friendshome;
	}

	public void setFriendshome(FriendsHome friendshome) {
		this.friendshome = friendshome;
	}

	

}
