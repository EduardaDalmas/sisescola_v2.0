package br.com.ienh.sisescola.dao;

import java.util.List;

import br.com.ienh.sisescola.database.ConnectionDatabase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class DAOGenerics <T, U> implements DAO<T, U>{
	
	private ConnectionDatabase connection;
	private EntityManager entityManager;
	private Class<T> entityType;
	
	public DAOGenerics(Class<T> persistedClass) throws Exception{
		connection = ConnectionDatabase.getConnection();
		entityManager = connection.getEntityManager();
		entityType = persistedClass;
	}

	public T findById(U id) throws Exception{
		T obj = entityManager.find(entityType, id);
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws Exception{
		String consulta = "from " + entityType.getSimpleName();
		Query query = entityManager.createQuery(consulta);
		return query.getResultList();
	}

	public void insert(T obj) throws Exception{
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		flushAndClear();
		entityManager.getTransaction().commit();
	}

	public void update(T obj) throws Exception{
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		flushAndClear();
		entityManager.getTransaction().commit();
	}

	public void remove(T obj) throws Exception{
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		flushAndClear();
		entityManager.getTransaction().commit();
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
	
}
