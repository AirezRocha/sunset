package br.com.sunset.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sunset.crm.model.Person;

@Repository
public interface ProspectRepository extends PersonRepository{
	
	@Query(value = "SELECT * FROM tb_person WHERE (UPPER(name) like %?1% or UPPER(document) like %?1%) and  category = 1 and is_active = true", nativeQuery = true)
	List<Person> getFindByNameOrDocument(String value);
}
