package pfe.micro.assurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pfe.micro.assurance.entity.TypeAssurance;

@Service
public interface TypeAssuranceService {
	
	TypeAssurance createType(TypeAssurance type);
	List<TypeAssurance> getAll();
	
	public TypeAssurance updateUser(TypeAssurance type);
	public void deleteTypeAssurance(Integer id);
	
	public TypeAssurance updateType(TypeAssurance type);
	
	public TypeAssurance getType(Integer typeId);
	
	//get Assurances d'un assureur
	List<TypeAssurance> getTypeByUserId(Integer userId);

}
