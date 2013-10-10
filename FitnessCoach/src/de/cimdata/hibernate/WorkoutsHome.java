package de.cimdata.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class WorkoutsHome implements Serializable{

	private static final long serialVersionUID = 1L;
	private HibernateUtil hbn = HibernateUtil.getInstance();
	
	public WorkoutsHome() {
		hbn.createHibernateSession();
	}
	
	public List<Workouts> findAllWorkouts() {
		Session session = hbn.currentSession();
		Query q = null;
		q = session.createQuery("form Workouts");
				
		return q.list();
	}

}
