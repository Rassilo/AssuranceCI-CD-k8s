package pfe.micro.auth.config;

import java.util.Map;

import pfe.micro.auth.model.User;

public interface JwtGeneratorInterface {
	
	Map<String, String> generateToken(User user);

}
