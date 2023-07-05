package pfe.micro.assurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pfe.micro.assurance.entity.Souscription;
import pfe.micro.assurance.service.SouscriptionService;

@RestController
@RequestMapping("/api/v2/souscription")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SouscriptionController {
	
	@Autowired
	private SouscriptionService service;

	@PostMapping("/save")
	public ResponseEntity<Souscription> createSouscription(@RequestBody Souscription souscription){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createSouscription(souscription));
	}
	
	@GetMapping("/souscriptions")
	public ResponseEntity<List<Souscription>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{souscriptionId}")
	public Souscription getSouscription(@PathVariable("souscriptionId") Integer souscriptionId) {
		return service.getSouscription(souscriptionId);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Souscription> updateSouscription(@RequestBody Souscription souscription){
		return ResponseEntity.ok(this.service.updateSouscription(souscription));
	}
	
	//les souscriptions d'un assurée
	@GetMapping("/assuree/{userId}")
	public ResponseEntity<List<Souscription>> getByUserId(@PathVariable("userId") String userId){
		return ResponseEntity.ok(service.getSouscriptionByUserId(userId));
	}
	
	//les demandes de souscriptions envoyer à un assureur
	@GetMapping("/assureur/{assureurId}")
	public ResponseEntity<List<Souscription>> getByAssureurId(@PathVariable("assureurId") String assureurId){
		return ResponseEntity.ok(service.getSouscriptionByAssureurId(assureurId));
	}
}
