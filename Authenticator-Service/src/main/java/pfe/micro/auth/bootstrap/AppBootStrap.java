package pfe.micro.auth.bootstrap;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import pfe.micro.auth.model.Role;
import pfe.micro.auth.model.Sexe;
import pfe.micro.auth.model.User;
import pfe.micro.auth.repository.UserRepository;

@Component
public class AppBootStrap implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {

  
		List<User> users = userRepository.findAll();
		User user = new User("SUPER","ADMIN","1239987" ,"" ,"","40526874" ,"1995-05-10","","Administrateur","tunis","superAdmin@gmail.com", "Superadmin123@", true,"", "", Role.SUPER_ADMIN, Sexe.HOMME);
		boolean userExists = false;
		for (User existingUser : users) {
			if (existingUser.getUserName().equals(user.getUserName())) {
		        userExists = true;
		        break;
		    }
		}
		if (!userExists) {
			user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
		    userRepository.save(user);
		}
		
		
		
		
	}

}
