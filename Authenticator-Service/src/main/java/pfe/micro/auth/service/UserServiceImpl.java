package pfe.micro.auth.service;


import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.micro.auth.exception.UserNotFoundException;
import pfe.micro.auth.model.Role;
import pfe.micro.auth.model.User;
import pfe.micro.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public void saveUser(User user) {
		
		userRepository.save(user);
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
		User user = userRepository.findByUserNameAndPassword(name, password);
		if(user == null){
            throw new UserNotFoundException("Invalid id and password");
        }
        return user;
	}

	@Override
	public User getUser(String username) {
		return this.userRepository.findByUserName(username);
	}

	@Override
	public void deleteUser(Integer userId) {
		this.userRepository.deleteById(userId);
	}

	
	@Override
	public User updateUser(User user) {
		
		return this.userRepository.save(user);
	}

	@Override
	public Set<User> getUsers() {
		
		return new LinkedHashSet<>(this.userRepository.findAll());
	}

	@Override
	public Set<User> getAssureur(Role role) {
		return this.userRepository.findByRole(role);
	}

	@Override
	public User getUserById(Integer id) {
		
		User user = userRepository.findUserById(id);
		
		return user;
	}

}
