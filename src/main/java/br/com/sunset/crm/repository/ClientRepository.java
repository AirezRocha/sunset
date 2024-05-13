package br.com.sunset.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sunset.crm.model.Person;

@Repository
public interface ClientRepository extends PersonRepository{

	@Query(value = "SELECT * FROM tb_person WHERE category = 2 and is_active = true", nativeQuery = true)
	List<Person> findAll();
}
