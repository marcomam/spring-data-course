package br.com.spring.data.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractHibernateDAO<T extends Serializable> {
	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;
	
	public void setClazz(Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	public T findOne(long id) {
		return (T) entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T update(T entity) {
		return (T) entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(long id) {
		final T entity = findOne(id);
		delete(entity);
	}
}
