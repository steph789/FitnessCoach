package de.cimdata.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

// Generated 07.10.2013 11:17:37 by Hibernate Tools 4.0.0

/**
 * Home object for domain model class Friends.
 * 
 * @see de.cimdata.hibernate.Friends
 * @author Hibernate Tools
 */
public class FriendsHome implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HibernateUtil hbn = HibernateUtil.getInstance();

	public FriendsHome() {
		hbn.createHibernateSession();
	}

	public List<User> findAllFriendsID(long userid) {
		List<User> friends = new ArrayList<>();
		List<Long> idList = null;

		Query q = null;
		Query q2 = null;
		Session session = hbn.currentSession();
//		q = session
//				.createQuery("select User u, Friends f where f.friend_id=u.user_id and f.user_id= :userid");
		
		q = session.createQuery("select f.friendId from Friends f where f.userId= :userid");
		q.setLong("userid", userid);
		idList = q.list();
		System.out.println("Anzahl in Liste: " + idList.size());
		
		for (Long fid : idList) {
			User u = (User) session.load(User.class, fid);
			System.out.println("Freund gefunden: " + u.getUsername());
			friends.add(u);
		}

		return friends;
	}

	public List<User> findAllUserNotFriends(long userid) {
		List<User> friends = this.findAllFriendsID(userid);
		List<User> users = new ArrayList<>();
		List<User> newFriends = new ArrayList<>();
		
		Query q = null;
		Session session = hbn.currentSession();
		q = session.createQuery("From User");
		users = q.list();
		
		
		for(int i = 0; i < users.size(); i++) {
			if(!friends.contains(users.get(i))) {
				newFriends.add(users.get(i));
				System.out.println("In neuer Liste: " + users.get(i).getUsername());
			}
		}
		
		Query q2 = null;
		q2 = session.createQuery("From User u where u.userId= :userid");
		q2.setLong("userid", userid);
		User self = (User) q.list().get(0);
		
		newFriends.remove(self);
		
		return newFriends;
	}
	
	public void attachNewFriend(Friends friends) {
		Session session1 = hbn.currentSession();
		Transaction t1 = session1.beginTransaction();
		
		System.out.println("------------------------Freunde eintragen: User " + friends.getUserId() + " - " + friends.getFriendId());
		
		//1. Eintrag eingeloggter User = user_id, der andere ist Freund
		session1.save(friends);
		t1.commit();;

		Session session2 = hbn.currentSession();
		
		System.out.println("---------------------------Session 2 gestartet");
		//2. Eintrag User und Freund tauschen Plätze
		Friends friends2 = new Friends();
		friends2.setUserId(friends.getFriendId());
		friends2.setFriendId(friends.getUserId());
		Transaction t2 = session2.beginTransaction();
		session2.save(friends2);
		t2.commit();

	}
	
	public static void main(String[] args) {
		FriendsHome fh = new FriendsHome();
		System.out.println(fh.findAllUserNotFriends(1));
	}

}
