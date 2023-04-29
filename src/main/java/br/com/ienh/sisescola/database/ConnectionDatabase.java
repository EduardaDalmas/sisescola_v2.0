package br.com.ienh.sisescola.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// aplicação do padrão Singleton
public class ConnectionDatabase {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static ConnectionDatabase connection;
	
	private ConnectionDatabase() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("SisEscola");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static ConnectionDatabase getConnection() throws Exception {
		if(connection == null) {
			connection = new ConnectionDatabase();
		}
		return connection;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
		
}
