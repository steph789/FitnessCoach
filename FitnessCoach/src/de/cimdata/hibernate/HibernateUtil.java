package de.cimdata.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * This file is generated from a template that you can modify if you want
 * different behaviour.
 * 
 */
public class HibernateUtil {
	private static HibernateUtil instance = null;
	private static SessionFactory sessionFactory;
	private static final ThreadLocal<Session> session = new ThreadLocal<>();
	private Session currentSession = null;
	private static ServiceRegistry serviceRegistry;

	public static HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}

	public void createHibernateSession() {

		try {
			// sessionFactory = new
			// Configuration().configure().buildSessionFactory();

			Configuration conf = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					conf.getProperties()).buildServiceRegistry();
			sessionFactory = new Configuration().configure()
					.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		currentSession = (Session) session.get();
		if (currentSession == null) {
			currentSession = sessionFactory.openSession();
			session.set(currentSession);
		}
	}

	/**
	 * 
	 * @return session
	 * @throws HibernateException
	 */
	public Session currentSession() throws HibernateException {
		return this.currentSession;
	}

	public void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null) {
			s.close();
		}
	}

	/**
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}