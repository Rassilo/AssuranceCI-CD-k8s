package pfe.micro.assurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.micro.assurance.entity.Souscription;
import pfe.micro.assurance.repository.SouscriptionRepository;
import pfe.micro.assurance.service.SouscriptionService;

@Service
public class SouscriptionServiceImpl implements SouscriptionService{
	
	@Autowired
	private SouscriptionRepository repository;

	@Override
	public Souscription createSouscription(Souscription souscription) {
		
		return repository.save(souscription);
	}

	@Override
	public Souscription updateSouscription(Souscription souscription) {
		return repository.save(souscription);
	}

	@Override
	public List<Souscription> getAll() {
		return repository.findAll();
	}

	@Override
	public Souscription getSouscription(Integer souscriptionId) {
		return repository.findSouscriptionBySouscriptionId(souscriptionId);
	}

	@Override
	public List<Souscription> getSouscriptionByUserId(String userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<Souscription> getSouscriptionByAssureurId(String assureurId) {
		
		return repository.findByAssureurId(assureurId);
	}

}
