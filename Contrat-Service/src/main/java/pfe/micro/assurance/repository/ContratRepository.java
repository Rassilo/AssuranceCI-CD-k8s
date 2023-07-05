package pfe.micro.assurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfe.micro.assurance.entity.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer>{
	
	List<Contrat> findBySouscriptionId(Integer souscriptionId);

}
