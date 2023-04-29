package br.com.ienh.sisescola.dao;

import java.util.List;

//aplicação do padrão DAO
public interface DAO <T, U>{

	public T findById(U id) throws Exception;
	public List<T> findAll() throws Exception;
	public void insert(T obj) throws Exception;
	public void update(T obj) throws Exception;
	public void remove(T obj) throws Exception;

}

