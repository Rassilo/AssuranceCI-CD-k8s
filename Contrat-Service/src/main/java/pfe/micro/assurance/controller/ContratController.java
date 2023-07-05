package pfe.micro.assurance.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pfe.micro.assurance.entity.Contrat;
import pfe.micro.assurance.message.ResponseFile;
import pfe.micro.assurance.message.ResponseMessage;
import pfe.micro.assurance.service.ContratService;

@RestController
@RequestMapping("/api/v3/contrat")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContratController {
	
	@Autowired
	private ContratService contratService;
	
	@PostMapping("/upload/{souscriptionId}")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable Integer souscriptionId) {
	    String message = "";
	    try {
	    	contratService.ajouterContrat(file,souscriptionId);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	@GetMapping("/contrat/{souscriptionId}")
	  public ResponseEntity<List<ResponseFile>> getBySouscriptionId(@PathVariable Integer souscriptionId) {
	    
	    List<ResponseFile> files = contratService.getBySouscriptionId(souscriptionId).map(dbFile -> {
		      String fileDownloadUri = ServletUriComponentsBuilder
		          .fromCurrentContextPath()
		          .path("/api/v2/contrat/files/")
		          .path(dbFile.getContratId().toString())
		          .toUriString();

		      return new ResponseFile(
		    	  dbFile.getContratId(),
		          dbFile.getFileName(),
		          fileDownloadUri,
		          dbFile.getType(),
		          dbFile.getData().length,
		          dbFile.isEtat()
		    		  );
		      	  
		    }).collect(Collectors.toList());

		    return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	@GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = contratService.getAllContrat().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/api/v2/contrat/files/")
	          .path(dbFile.getContratId().toString())
	          .toUriString();

	      return new ResponseFile(
	    	  dbFile.getContratId(),
	          dbFile.getFileName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length,
	          dbFile.isEtat()
	    		  );
	      	  
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	
	
	@GetMapping("/files/{contratId}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Integer contratId) {
	    Contrat contrat = contratService.getContrat(contratId);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + contrat.getFileName() + "\"")
	        .body(contrat.getData());
	}
	  
	  
	  
	@PutMapping("/update")
	public ResponseEntity<Contrat> update(@RequestBody Contrat contrat){
		return ResponseEntity.ok(this.contratService.updateContrat(contrat));
	}
	
	@PutMapping("/update/{contratId}")
	public ResponseEntity<Contrat> update(@PathVariable("contratId") Integer contratId,@RequestBody boolean etat){
		return ResponseEntity.ok(this.contratService.updateEtat(contratId,etat));
	}

}
