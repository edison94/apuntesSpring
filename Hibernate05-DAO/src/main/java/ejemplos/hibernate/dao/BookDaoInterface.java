package ejemplos.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface BookDaoInterface<T, Id extends Serializable> {
	
	// The basic CRUD methods to interact with a database are Create, Read, Update and Delete.

	//CREATE
	public void persist(T entity);
	
	//READ
	public T findById(Id id);
	public List<T> findAll();	
	
	//UPDATE
	public void update(T entity);
	
	//DELETE
	public void delete(T entity);
	public void deleteById(Id id);	
	public void deleteAll();
	
}
