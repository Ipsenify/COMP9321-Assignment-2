package edu.unsw.comp9321.assign2.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.hibernate.HibernateMetadataUtil;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

public class DAOFactory {
	
	private static DAOFactory factory = new DAOFactory();

	private EntityManagerFactory emfactory;
	
	private DAOFactory(){
		emfactory = Persistence.createEntityManagerFactory("database");
	}
	
	public static DAOFactory getInstance(){
		return factory;
	}
	
	public EntityManager getEntityManager(){
		return emfactory.createEntityManager();
	}
	
	private SessionFactory getSessionFactory(){
		return ((HibernateEntityManagerFactory) emfactory).getSessionFactory();
	}
	
	private GenericDAOImpl instantiateDAO(GenericDAOImpl dao){
		dao.setEntityManager(getEntityManager());
		dao.setSearchProcessor(new JPASearchProcessor(HibernateMetadataUtil.getInstanceForSessionFactory(getSessionFactory())));
		return dao;
	}

	public UserDAO getUserDAO(){
		UserDAO dao = (UserDAO) instantiateDAO(new UserDAO());
		return dao;
	}
	
}
