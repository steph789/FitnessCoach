package de.cimdata.hibernate;

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
public class FriendsHome {

	private HibernateUtil hbn = HibernateUtil.getInstance();

	public FriendsHome() {
		hbn.createHibernateSession();
	}

	public List<User> findAllFriendsID(long userid) {
		List<User> friends = null;
		List<Long> idList = null;

		Query q = null;
		Query q2 = null;
		Session session = hbn.currentSession();
//		q = session
//				.createQuery("select User u, Friends f where f.friend_id=u.user_id and f.user_id= :userid");
		
		q = session.createQuery("select f.friendsID from Friends f where f.userID= :userid");
		q.setLong("userid", userid);
		idList = q.list();
		
		for (Long fid : idList) {
			User u = (User) session.load(User.class, fid);
			friends.add(u);
		}

		return friends;
	}

	public List<User> findAllUserNotFriends(long userid) {
		List<User> friends = this.findAllFriendsID(userid);
		List<User> users = null;
		
		Query q = null;
		Session session = hbn.currentSession();
		q = session.createQuery("From User");
		users = q.list();
		
		for(int i = 0; i < users.size(); i++) {
			for(int j = 0; j < friends.size(); j++) {
				if(users.get(i).equals(friends.get(j))) {
					users.remove(i);
				}
			}
		}
		
		return users;
	}
	
	public void attachNewFriend(Friends friends) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		session.saveOrUpdate(friends);
		t.commit();
	}

	
	
	public static void main(String[] args) {
		FriendsHome fh = new FriendsHome();
		System.out.println(fh.findAllFriendsID(1));
	}

}
