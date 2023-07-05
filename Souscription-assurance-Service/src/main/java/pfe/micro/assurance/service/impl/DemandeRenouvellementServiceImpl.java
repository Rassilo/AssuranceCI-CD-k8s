package pfe.micro.assurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.micro.assurance.entity.DemandeRenouvellement;
import pfe.micro.assurance.repository.DemandeRenouvellementRepository;
import pfe.micro.assurance.service.DemandeRenouvellementService;

@Service
public class DemandeRenouvellementServiceImpl implements DemandeRenouvellementService{
	@Autowired
	private DemandeRenouvellementRepository repository;
	@Override
	public DemandeRenouvellement createDemande(DemandeRenouvellement demande) {
		
		return repository.save(demande);
	}

	@Override
	public DemandeRenouvellement updateDemande(DemandeRenouvellement demande) {
		
		return repository.save(demande);
	}

	@Override
	public List<DemandeRenouvellement> getAll() {
		return repository.findAll();
	}

	@Override
	public List<DemandeRenouvellement> getBySouscriptionId(Integer souscriptionId) {
		
		return repository.findBySouscriptionId(souscriptionId);
	}

	@Override
	public DemandeRenouvellement getBydemandeId(Integer renouvellementId) {
		return repository.findById(renouvellementId).get();
	}

	@Override
	public List<DemandeRenouvellement> getByAssureurId(Integer assureurId) {
		
		return repository.findByAssureurId(assureurId);
	}
}
