package pfe.micro.assurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pfe.micro.assurance.entity.Souscription;

@Service
public interface SouscriptionService {
	
	Souscription createSouscription(Souscription souscription);
	Souscription updateSouscription(Souscription souscription);
	
	List<Souscription> getAll();
	
	Souscription getSouscription(Integer souscriptionId);
	
	List<Souscription> getSouscriptionByUserId(String userId);
	
	List<Souscription> getSouscriptionByAssureurId(String assureurId);
}
