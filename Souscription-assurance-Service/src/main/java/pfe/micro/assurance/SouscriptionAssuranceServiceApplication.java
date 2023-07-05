package pfe.micro.assurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SouscriptionAssuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SouscriptionAssuranceServiceApplication.class, args);
	}

}
