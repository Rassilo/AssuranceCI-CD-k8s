package pfe.micro.auth.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import pfe.micro.auth.exception.UserNotFoundException;
import pfe.micro.auth.model.Role;
import pfe.micro.auth.model.User;

@Service
public interface UserService {

	public void saveUser(User user);
	
	public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
	
	public User getUser(String username);
	
	public User getUserById(Integer id);
	
	public Set<User> getUsers();
	
	public Set<User> getAssureur(Role role);
	
	public User updateUser(User user);
	public void deleteUser(Integer userId);
}
