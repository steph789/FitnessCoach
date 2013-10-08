package de.cimdata.hibernate;

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

	
}
