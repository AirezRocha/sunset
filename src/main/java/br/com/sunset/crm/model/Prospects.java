package br.com.sunset.crm.model;

import java.util.Date;

import br.com.sunset.crm.enums.PersonCategory;

public class Prospects extends Person {

	public Prospects() {
		super(PersonCategory.PROSPECT);
	}

	public Prospects(long id) {
		super(id, PersonCategory.PROSPECT);
		// TODO Auto-generated constructor stub
	}

	public Prospects(long id, String name, String document, Date birth, String city) {
		super(id, name, document, birth, city, PersonCategory.PROSPECT);
		// TODO Auto-generated constructor stub
	}
}
