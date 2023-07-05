package pfe.micro.assurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pfe.micro.assurance.entity.SelectedType;

public interface SelectedTypeRepository extends JpaRepository<SelectedType, Integer>{

	public SelectedType findSelectedTypeBySelectedtypeId(Integer selectedtypeId);
	public SelectedType findSelectedTypeByUserId(Integer userId);
	
}