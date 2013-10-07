package hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import de.cimdata.data.NewUserData;


// Generated 07.10.2013 11:17:37 by Hibernate Tools 4.0.0


/**
 * Home object for domain model class User.
 * @see hibernate.User
 * @author Hibernate Tools
 */
public class UserHome {
	
	private HibernateUtil hbn = HibernateUtil.getInstance();
	
	public UserHome() {
		hbn.createHibernateSession();
	}
	
	public List<User> findAllUser() {
		Query q = null;
		Session session = hbn.currentSession();
		q = session.createQuery("From User");
		return q.list();
	}
	
	
	public List<User> findUserByUsernameAndPassword(String username, String password) {
		Session session = hbn.currentSession();
		Criteria criteria = session.createCriteria(User.class);
		
		User tmpUser = new User();
		tmpUser.setUsername(username);
		tmpUser.setPassword(password);
		
		Example example = Example.create(tmpUser);
		criteria.add(example);
		
		return criteria.list();
	}
	
	public void updateEmail(long id, String newEmail) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		user.setEmail(newEmail);
		
		session.update(user);
		t.commit();
	}
	
	public void updateRun(long id, int newRun) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		user.setRun(newRun);
		
		session.update(user);
		t.commit();
	}
	
	public void updateBike(long id, int newBike) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		user.setBike(newBike);
		
		session.update(user);
		t.commit();
	}
	
	public void updateSwim(long id, int newSwim) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		user.setSwim(newSwim);
		
		session.update(user);
		t.commit();
	}
	
	public void updatePump(long id, int newPump) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		user.setPump(newPump);
		
		session.update(user);
		t.commit();
	}
	
	public void updateStatus(long id, String newStatus) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		user.setStatus(newStatus);
		
		session.update(user);
		t.commit();
	}
	
	public void updateFitnesslevel(long id, int newFitnesslevel) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		user.setFitnesslevel(newFitnesslevel);
		
		session.update(user);
		t.commit();
	}
	
	public void attachUser(User user) {
		Session session = hbn.currentSession();
		Transaction t = session.beginTransaction();
		
		session.saveOrUpdate(user);
		t.commit();
	}

	public static void main(String[] args) {
		
		User newuser = new User();
		newuser.setUsername("maja");
		newuser.setPassword("test");
		newuser.setFirstname("Biene");
		newuser.setLastname("Maja");
		newuser.setEmail("biene@maje.de");
		newuser.setHeight(1.65);
		newuser.setSex(false);
		newuser.setYearbirth(1985);
		
		UserHome uh = new UserHome();
		
		uh.attachUser(newuser);
	
	}

}
