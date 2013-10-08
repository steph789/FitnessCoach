package de.cimdata.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

// Generated 07.10.2013 11:17:37 by Hibernate Tools 4.0.0


/**
 * Home object for domain model class Friends.
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

		Query q = null;
		Session session = hbn.currentSession();
		q = session.createQuery("select for User u, Friends f where f.friend_id=u.user_id and f.user_id= :userid");
		friends = q.list();
		
		return friends;
	}
	
	public List<User> findAllUser() {
		Query q = null;
		Session session = hbn.currentSession();
		q = session.createQuery("From User");
		return q.list();
	}

	
}
