package br.com.sunset.crm.dto;

import java.util.Date;

public class ProspectDTO {
	private long id;
	private String name;
	private String document;
	private Date birth;
	private String city;
	
	public ProspectDTO(long id, String name, String document, Date birth, String city) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birth = birth;
        this.city = city;
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
}
