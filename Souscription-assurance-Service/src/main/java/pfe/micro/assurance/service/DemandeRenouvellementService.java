package pfe.micro.assurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pfe.micro.assurance.entity.DemandeRenouvellement;

@Service
public interface DemandeRenouvellementService {
	
	DemandeRenouvellement createDemande(DemandeRenouvellement demande);
	DemandeRenouvellement updateDemande(DemandeRenouvellement demande);
	
	DemandeRenouvellement getBydemandeId(Integer renouvellementId);
	
	List<DemandeRenouvellement> getAll();
	
	List<DemandeRenouvellement> getBySouscriptionId(Integer souscriptionId);
	
	List<DemandeRenouvellement> getByAssureurId(Integer assureurId);

}
