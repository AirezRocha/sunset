package br.com.sunset.crm.model;

import java.util.Date;
import br.com.sunset.crm.enums.PersonCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String document;
	private Date birth;
	private String city;
	private PersonCategory category;
	private boolean isActive = true;
	private Date clientSince;

	public Person() {
	}

	public Person(PersonCategory category) {
		this.category = category;
	}

	public Person(long id, PersonCategory category) {
		this.id = id;
		this.category = category;
	}

	public Person(long id, String name, String document, Date birth, String city, PersonCategory category) {
		this.id = id;
		this.name = name;
		this.document = document;
		this.birth = birth;
		this.city = city;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PersonCategory getCategory() {
		return category;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getClientSince() {
		return clientSince;
	}

	public void setClientSince(Date clientSince) {
		this.clientSince = clientSince;
	}
}
