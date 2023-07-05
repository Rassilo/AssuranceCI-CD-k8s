package pfe.micro.assurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.micro.assurance.entity.Souscription;

@Repository
public interface SouscriptionRepository extends JpaRepository<Souscription, Integer>{
	
	Souscription findSouscriptionBySouscriptionId(Integer souscriptionId);
	
	
	List<Souscription> findByUserId(String userId);
	
	List<Souscription> findByAssureurId(String assureurId);
	
	
	

}
