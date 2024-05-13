package br.com.sunset.crm.service;
import java.util.List;

public interface Service <T>{
	
	public T create(T obj);
	
	public T update(T obj);
	
	public T getById(long id);
	
	public List<T> get();
	
	public void delete(T obj);
	
}
