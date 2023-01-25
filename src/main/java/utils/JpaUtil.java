package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JpaUtil {
	private static final Logger logger = LoggerFactory.getLogger(JpaUtil.class);

	private static final EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("BE-Week3-Esercizio3");
		} catch (Throwable ex) {
			logger.error("Initial EntityManagerFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static EntityManager getEntityManager() {
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

}