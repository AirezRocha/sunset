package br.com.sunset.crm.model;

import java.util.Date;

import br.com.sunset.crm.enums.PersonCategory;

public class Client extends Person{
	public Client() {
		super(PersonCategory.CLIENT);
	}

	public Client(long id) {
		super(id, PersonCategory.CLIENT);
		// TODO Auto-generated constructor stub
	}

	public Client(long id, String name, String document, Date birth, String city) {
		super(id, name, document, birth, city, PersonCategory.CLIENT);
		// TODO Auto-generated constructor stub
	}

}
