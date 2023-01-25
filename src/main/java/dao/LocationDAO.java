package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Location;
import utils.JpaUtil;


public class LocationDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);
	private static final EntityManager em = JpaUtil.getEntityManager();

	public void save(Location object) {
		try {
			EntityTransaction transaction = em.getTransaction();
			
			transaction.begin();
			em.persist(object);
			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public void refresh(Location object) {
		try {
			em.refresh(object);
		} finally {
			em.close();
		}
	}

	public Location getById(Long id) {
		try {
			return em.find(Location.class, id);
		} finally {
			em.close();
		}
	}

	public void delete(Location object) {
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(object);
			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

}
