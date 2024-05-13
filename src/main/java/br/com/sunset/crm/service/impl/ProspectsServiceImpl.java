package br.com.sunset.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sunset.crm.enums.PersonCategory;
import br.com.sunset.crm.model.Person;
import br.com.sunset.crm.model.Prospects;
import br.com.sunset.crm.repository.ProspectRepository;
import br.com.sunset.crm.service.ProspectService;

@org.springframework.stereotype.Service
public class ProspectsServiceImpl extends PersonServiceImpl implements ProspectService{

	@Autowired
	private ProspectRepository prospectsRepository;

	@Override
	public Prospects create(Person obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Objeto não pode ser nulo.");
		}

		Person entity = new Person(obj.getId(), obj.getName(), obj.getDocument(), obj.getBirth(), obj.getCity(),
				obj.getCategory());

		entity = prospectsRepository.save(entity);

		var pros = new Prospects(entity.getId(), entity.getName(), entity.getDocument(), entity.getBirth(),
				entity.getCity());

		return pros;
	}

	@Override
	public Prospects update(Person obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Objeto não pode ser nulo.");
		}
		if (!prospectsRepository.existsById(obj.getId())) {
			throw new IllegalArgumentException("Prospect com ID " + obj.getId() + " não encontrado.");
		}

		Person entity = new Person(obj.getId(), obj.getName(), obj.getDocument(), obj.getBirth(), obj.getCity(),
				obj.getCategory());

		entity = prospectsRepository.save(entity);

		var pros = new Prospects(entity.getId(), entity.getName(), entity.getDocument(), entity.getBirth(),
				entity.getCity());

		return pros;
	}

	@Override
	public Prospects getById(long id) {
		var result = prospectsRepository.findById(id);
		if (result.isPresent()) {
			var entity = result.get();
			return new Prospects(entity.getId(), entity.getName(), entity.getDocument(), entity.getBirth(),
					entity.getCity());
		} else {
			throw new IllegalArgumentException("Prospect com ID " + id + " não encontrado.");
		}
	}

	@Override
	public List<Person> get() {

		List<Prospects> list = new ArrayList<Prospects>();

		var result = prospectsRepository.findAllProspects();

		result.forEach(entity -> {
			list.add(new Prospects(entity.getId(), entity.getName(), entity.getDocument(), entity.getBirth(),
					entity.getCity()));
		});

		return result;
	}

	@Override
	public void delete(Person obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Objeto não pode ser nulo.");
		}
		if (!prospectsRepository.existsById(obj.getId())) {
			throw new IllegalArgumentException("Prospect com ID " + obj.getId() + " não encontrado.");
		}

		obj = this.getById(obj.getId());

		Person entity = new Person(obj.getId(), obj.getName(), obj.getDocument(), obj.getBirth(), obj.getCity(),
				obj.getCategory());

		entity.setActive(false);

		entity = prospectsRepository.save(entity);

	}
	
	@Override
	public void toClient(long id) {

		var obj = this.getById(id);

		if (obj == null) {
			throw new IllegalArgumentException("Objeto não pode ser nulo.");
		}
		if (!prospectsRepository.existsById(obj.getId())) {
			throw new IllegalArgumentException("Prospect com ID " + obj.getId() + " não encontrado.");
		}

		Person entity = new Person(obj.getId(), obj.getName(), obj.getDocument(), obj.getBirth(), obj.getCity(),
				PersonCategory.CLIENT);

		entity.setClientSince(new Date());

		entity = prospectsRepository.save(entity);


	}
	
	@Override
	public List<Prospects> getFindByNameOrDocument (String value) {
		List<Prospects> list = new ArrayList<Prospects>();

		var result = prospectsRepository.getFindByNameOrDocument(value.toUpperCase());

		result.forEach(entity -> {
			list.add(new Prospects(entity.getId(), entity.getName(), entity.getDocument(), entity.getBirth(),
					entity.getCity()));
		});

		return list;
	}

}
