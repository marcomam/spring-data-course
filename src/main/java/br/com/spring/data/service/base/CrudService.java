package br.com.spring.data.service.base;

import java.util.List;

public interface CrudService<T> {
	
	public T create(T obj);
	
	public T update(T obj);
	
	public T findById(Integer id);
	
	public List<T> findAll();
	
	public void deleteById(Integer id);
}
