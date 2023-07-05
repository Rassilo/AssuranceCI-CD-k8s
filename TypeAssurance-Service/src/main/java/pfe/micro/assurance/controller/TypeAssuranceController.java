package pfe.micro.assurance.controller;

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

import pfe.micro.assurance.entity.TypeAssurance;
import pfe.micro.assurance.service.TypeAssuranceService;

@RestController
@RequestMapping("/api/v4/type")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeAssuranceController {
	
	@Autowired
	private TypeAssuranceService typeService;
	
	@PostMapping("/save")
	public ResponseEntity<TypeAssurance> createType(@RequestBody TypeAssurance type){
		return ResponseEntity.status(HttpStatus.CREATED).body(typeService.createType(type));
	}
	
	@GetMapping("/types")
	public ResponseEntity<List<TypeAssurance>> getAll(){
		return ResponseEntity.ok(typeService.getAll());
	}
	
	@GetMapping("/{typeId}")
	public TypeAssurance getType(@PathVariable("typeId") Integer typeId) {
		return this.typeService.getType(typeId);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<TypeAssurance> updateDecision(@RequestBody TypeAssurance type){
		return ResponseEntity.ok(this.typeService.updateType(type));
	}
	
	@DeleteMapping("/delete/{typeId}")
	public void deleteUser(@PathVariable("typeId") Integer typeId) {
		this.typeService.deleteTypeAssurance(typeId);
	}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<TypeAssurance>> getByUserId(@PathVariable Integer userId){
		return ResponseEntity.ok(typeService.getTypeByUserId(userId));
	}


}
