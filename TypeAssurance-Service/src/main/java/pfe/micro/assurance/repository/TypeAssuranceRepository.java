package pfe.micro.assurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfe.micro.assurance.entity.TypeAssurance;

public interface TypeAssuranceRepository extends JpaRepository<TypeAssurance, Integer>{

	public TypeAssurance findTypeAssuranceByTypeId(Integer id);
	
	List<TypeAssurance> findByUserId(Integer userId);
	
	List<TypeAssurance> findByUserIdIn(List<Integer> skuCode);
}