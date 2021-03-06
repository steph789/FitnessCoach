package de.cimdata.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

// Generated 07.10.2013 11:17:37 by Hibernate Tools 4.0.0


/**
 * Home object for domain model class Weights.
 * @see de.cimdata.hibernate.Weights
 * @author Hibernate Tools
 */
public class WeightsHome implements Serializable{

	private static final long serialVersionUID = 1L;
	private HibernateUtil hbn = HibernateUtil.getInstance();
	
	public WeightsHome() {
		hbn.createHibernateSession();
	}
	
	public List<Weights> findWeightsByID(long userid) {
		Session session = hbn.currentSession();
		Query q = null;
		q = session.createQuery("From Weights w where w.userId= :userid");
		q.setLong("userid", userid);
		
		return q.list();
	}
	
	public double findLastWeight(List<Weights> list) {
		double weight = 0;

		long dateMax;
		long temp = 0;
		for (Weights weights : list) {
			dateMax = weights.getDate().getTime();
			if(dateMax > temp) {
				temp = dateMax;
				weight = weights.getWeight();
			}
			else dateMax = temp;
		}

		return weight;
	}
	
	public void attachWeight(Weights weight) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		session.save(weight);
		System.out.println("Gewicht eingetragen: " + weight.getWeight());
		t.commit();
	}
	
	public void deleteWeight(Long wid) {
		//Long id = weights.getWeightsId();
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		//Query q = null;
		//q = session.createQuery("delete from Weights w where w.weightsId= :id");
		
		Weights weight = (Weights) session.load(Weights.class, wid);
		session.delete(weight);
		//q.setLong("id", wid);
		System.out.println(":::::::::::::::::::::::::::::::::::::::Eintrag wird gel�scht: " + wid);
		
		t.commit();
		
		System.out.println("committed?"+t.wasCommitted());
		
		
	}
	
	
	public static void main(String[] args) {
		Weights w1 = new Weights(109.8,new Date(136297440),3);
		Weights w2 = new Weights(99.2,new Date(1367035200),3);
		Weights w3 = new Weights(98.8,new Date(1367985600),3);
		Weights w4 = new Weights(92.1,new Date(1370664000),3);
		Weights w5 = new Weights(88.7,new Date(1372564800),3);
		Weights w6 = new Weights(87.4,new Date(1373342400),3);
		
		WeightsHome wh = new WeightsHome();
		wh.attachWeight(w1);
		wh.attachWeight(w2);
		wh.attachWeight(w3);
		wh.attachWeight(w4);
		wh.attachWeight(w5);
		wh.attachWeight(w6);
		
	}

}
