package br.com.sunset.crm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sunset.crm.dto.ProspectDTO;
import br.com.sunset.crm.service.ClientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<List<ProspectDTO>> getAllProspects() {

		var prospects = clientService.get();

		List<ProspectDTO> result = new ArrayList<ProspectDTO>();

		prospects.forEach(p -> {
			result.add(new ProspectDTO(p.getId(), p.getName(), p.getDocument(), p.getBirth(), p.getCity()));
		});

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProspectDTO> getById(@PathVariable long id) {

		var p = clientService.getById(id);

		ProspectDTO result = new ProspectDTO(p.getId(), p.getName(), p.getDocument(), p.getBirth(), p.getCity());

		
		return ResponseEntity.ok(result);
	}
}
