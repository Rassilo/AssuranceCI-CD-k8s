package pfe.micro.assurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfe.micro.assurance.entity.DemandeRenouvellement;

public interface DemandeRenouvellementRepository extends JpaRepository<DemandeRenouvellement, Integer>{

	List<DemandeRenouvellement> findBySouscriptionId(Integer souscriptionId);
	List<DemandeRenouvellement> findByAssureurId(Integer assureurId);
	
}
