package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Evento;
import utils.JpaUtil;


public class EventoDAO extends JpaUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);
	private static final EntityManager em = JpaUtil.getEntityManager();

	public void save(Evento object) {
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

	public void refresh(Evento object) {
		try {
			em.refresh(object);
		} finally {
			em.close();
		}
	}

	public Evento getById(Long id) {
		try {
			return em.find(Evento.class, id);
		} finally {
			em.close();
		}
	}

	public void delete(Evento object) {
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
