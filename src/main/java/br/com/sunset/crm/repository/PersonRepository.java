package br.com.sunset.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sunset.crm.model.Person;


public interface PersonRepository  extends JpaRepository<Person, Long>{
	
	@Query(value = "SELECT * FROM tb_person WHERE category = 1 and is_active = true", nativeQuery = true)
	List<Person> findAllProspects();

}
