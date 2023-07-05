package pfe.micro.auth.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfe.micro.auth.model.Role;
import pfe.micro.auth.model.User;
import pfe.micro.auth.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
        	
        	user.setRole(Role.ASSUREE);
        	//encoding password with BCrypt
    		user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } 
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
	
	@PostMapping("/saveAssureur")
    public ResponseEntity<?> postAssureur(@RequestBody User user){
        try{
        	
        	user.setRole(Role.ASSUREUR);
        	//encoding password with BCrypt
    		user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } 
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
	
	@PostMapping("/saveAdmin")
    public ResponseEntity<?> postAdmin(@RequestBody User user){
        try{
        	
        	user.setRole(Role.ADMIN);
        	//encoding password with BCrypt
    		user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } 
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

	
	//get all users
	@GetMapping("/users")
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.userService.getUsers());
	}
	
	@GetMapping("/assureurs")
	public ResponseEntity<?> getAssureur(){
		Role role = Role.valueOf("ASSUREUR");
		Set<User> assureurs = this.userService.getAssureur(role);
		  
		  return ResponseEntity.ok(assureurs);
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	@GetMapping("/get/{id}")
	public User get(@PathVariable("id") Integer id) {
		
		return this.userService.getUserById(id);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId) {
		this.userService.deleteUser(userId);
	}
	
}