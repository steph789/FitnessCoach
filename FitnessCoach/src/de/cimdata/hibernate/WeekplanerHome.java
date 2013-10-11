package de.cimdata.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class WeekplanerHome implements Serializable{

	private static final long serialVersionUID = 1L;
	private HibernateUtil hbn = HibernateUtil.getInstance();
	
	public WeekplanerHome() {
		hbn.createHibernateSession();
	}
	
	public void attachNewPlan(Weekplaner plan) {
		Session session1 = hbn.currentSession();
		Transaction t1 = session1.beginTransaction();
		
		session1.saveOrUpdate(plan);
		t1.commit();
	}
	
	public Weekplaner findWeekplanByID(long userid) {
		Weekplaner plan = new Weekplaner();
		List<Weekplaner> planliste = new ArrayList<Weekplaner>();
		
		Session session = hbn.currentSession();
		Query q = null;
		q = session.createQuery("From Weekplaner w where w.userId= :userid");
		q.setLong("userid", userid);
		
		planliste = q.list();
		for (Weekplaner w : planliste) {
			plan = w;
		}
		
		return plan;
	}

}
