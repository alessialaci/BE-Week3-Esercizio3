package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Persona;
import utils.JpaUtil;


public class PersonaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);
	private static final EntityManager em = JpaUtil.getEntityManager();

	public void save(Persona object) {
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

	public void refresh(Persona object) {
		try {
			em.refresh(object);
		} finally {
			em.close();
		}
	}

	public Persona getById(Long id) {
		try {
			return em.find(Persona.class, id);
		} finally {
			em.close();
		}
	}

	public void delete(Persona object) {
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
