package br.com.sunset.crm.service;

import java.util.List;

import br.com.sunset.crm.model.Prospects;

public interface ProspectService extends PersonService{

	public void toClient(long id);

	public List<Prospects> getFindByNameOrDocument (String value);
}
