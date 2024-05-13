package br.com.sunset.crm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sunset.crm.dto.ProspectDTO;
import br.com.sunset.crm.model.Prospects;
import br.com.sunset.crm.service.ProspectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/prospect")
public class ProspectsController {

	@Autowired
	private ProspectService prospectsService;

	@GetMapping
	public ResponseEntity<List<ProspectDTO>> getAllProspects() {

		var prospects = prospectsService.get();

		List<ProspectDTO> result = new ArrayList<ProspectDTO>();

		prospects.forEach(p -> {
			result.add(new ProspectDTO(p.getId(), p.getName(), p.getDocument(), p.getBirth(), p.getCity()));
		});

		return ResponseEntity.ok(result);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProspectDTO> getById(@PathVariable long id) {

		var p = prospectsService.getById(id);

		ProspectDTO result = new ProspectDTO(p.getId(), p.getName(), p.getDocument(), p.getBirth(), p.getCity());

		
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<ProspectDTO> createProspect(@RequestBody ProspectDTO prospectDTO) {

		var model = new Prospects(prospectDTO.getId(), prospectDTO.getName(), prospectDTO.getDocument(),
				prospectDTO.getBirth(), prospectDTO.getCity());

		prospectsService.create(model);

		return ResponseEntity.status(HttpStatus.CREATED).body(prospectDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProspectDTO> updateProspect(@PathVariable long id, @RequestBody ProspectDTO prospectDTO) {

		var model = new Prospects(prospectDTO.getId(), prospectDTO.getName(), prospectDTO.getDocument(),
				prospectDTO.getBirth(), prospectDTO.getCity());

		prospectsService.update(model);

		return ResponseEntity.ok(prospectDTO);
	}
	
	@PutMapping("/to-client/{id}")
	public ResponseEntity<Void> toClient(@PathVariable long id) {

		prospectsService.toClient(id);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProspect(@PathVariable long id) {
		prospectsService.delete(new Prospects(id));
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findByNameOrDocument/{value}")
	public ResponseEntity<List<ProspectDTO>> getFindByNameOrDocument(@PathVariable  String value) {

		var prospects = prospectsService.getFindByNameOrDocument(value);

		List<ProspectDTO> result = new ArrayList<ProspectDTO>();

		prospects.forEach(p -> {
			result.add(new ProspectDTO(p.getId(), p.getName(), p.getDocument(), p.getBirth(), p.getCity()));
		});

		return ResponseEntity.ok(result);
	}
	
	
	

}
