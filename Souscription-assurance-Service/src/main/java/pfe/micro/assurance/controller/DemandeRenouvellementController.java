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

import pfe.micro.assurance.entity.DemandeRenouvellement;
import pfe.micro.assurance.service.DemandeRenouvellementService;

@RestController
@RequestMapping("/api/v2/souscription/renouvellement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DemandeRenouvellementController {
	@Autowired
	private DemandeRenouvellementService service;
	
	@PostMapping("/save")
	public ResponseEntity<DemandeRenouvellement> createDemande(@RequestBody DemandeRenouvellement demande){
		demande.setDecision("en attente");
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createDemande(demande));
	}
	
	@GetMapping("/demandes")
	public ResponseEntity<List<DemandeRenouvellement>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{renouvellementId}")
	public DemandeRenouvellement getSouscription(@PathVariable("renouvellementId") Integer renouvellementId) {
		return service.getBydemandeId(renouvellementId);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<DemandeRenouvellement> updateDemande(@RequestBody DemandeRenouvellement demande){
		return ResponseEntity.ok(this.service.updateDemande(demande));
	}
	
	
	@GetMapping("/demande/{souscriptionId}")
	public ResponseEntity<List<DemandeRenouvellement>> getBySouscriptionId(@PathVariable("souscriptionId") Integer souscriptionId){
		return ResponseEntity.ok(service.getBySouscriptionId(souscriptionId));
	}
	
	@GetMapping("/dem/{assureurId}")
	public ResponseEntity<List<DemandeRenouvellement>> getByUserId(@PathVariable("assureurId") Integer assureurId){
		return ResponseEntity.ok(service.getByAssureurId(assureurId));
	}

}
