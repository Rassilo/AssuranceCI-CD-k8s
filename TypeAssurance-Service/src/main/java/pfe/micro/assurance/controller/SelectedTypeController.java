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

import pfe.micro.assurance.entity.SelectedType;
import pfe.micro.assurance.service.SelectedTypeService;

@RestController
@RequestMapping("/api/v4/type/selected")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SelectedTypeController {
	
	@Autowired
	private SelectedTypeService service;
	
	@PostMapping("/save")
	public ResponseEntity<SelectedType> createSelected(@RequestBody SelectedType selected){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(selected));
	}
	
	@PutMapping("/update")
	public ResponseEntity<SelectedType> updateSelected(@RequestBody SelectedType selected){
		return ResponseEntity.ok(this.service.updateSelectedType(selected));
	}
	
	@GetMapping("/selecteds")
	public ResponseEntity<List<SelectedType>> getAll(){
		return ResponseEntity.ok(service.getSelectedTypes());
	}
	
	@GetMapping("/{selectedtypeId}")
	public SelectedType getSelected(@PathVariable("selectedtypeId") Integer selectedtypeId) {
		return this.service.getSelectedType(selectedtypeId);
	}
	
	@GetMapping("/user/{userId}")
	public SelectedType getSelectedByUser(@PathVariable("userId") Integer userId) {
		return this.service.getSelectedTypebyUser(userId);
	}
	
	@DeleteMapping("/delete/{selectedtypeId}")
	public void deleteUser(@PathVariable("selectedtypeId") Integer selectedtypeId) {
		this.service.delete(selectedtypeId);
	}
	

}
