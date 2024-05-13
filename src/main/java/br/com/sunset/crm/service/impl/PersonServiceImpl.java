package br.com.sunset.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sunset.crm.model.Person;
import br.com.sunset.crm.repository.PersonRepository;
import br.com.sunset.crm.service.PersonService;


public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person create(Person obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person update(Person obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> get() {
		return personRepository.findAll();
	}

	@Override
	public void delete(Person obj) {
		// TODO Auto-generated method stub

	}

}
