package br.com.sunset.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sunset.crm.model.Person;
import br.com.sunset.crm.model.Prospects;
import br.com.sunset.crm.repository.ClientRepository;
import br.com.sunset.crm.service.ClientService;

@Service
public class ClientServiceImpl extends PersonServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Person create(Person obj) {
		throw new NotImplementedException();
	}

	@Override
	public Person update(Person obj) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Person getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> get() {
		List<Prospects> list = new ArrayList<Prospects>();

		var result = clientRepository.findAll();

		result.forEach(entity -> {
			list.add(new Prospects(entity.getId(), entity.getName(), entity.getDocument(), entity.getBirth(),
					entity.getCity()));
		});

		return result;
	}

	@Override
	public void delete(Person obj) {
		throw new NotImplementedException();
	}

}
