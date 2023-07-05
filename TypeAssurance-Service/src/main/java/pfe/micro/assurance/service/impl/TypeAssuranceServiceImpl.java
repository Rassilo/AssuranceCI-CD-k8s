package pfe.micro.assurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pfe.micro.assurance.entity.TypeAssurance;
import pfe.micro.assurance.repository.TypeAssuranceRepository;
import pfe.micro.assurance.service.TypeAssuranceService;

@Service
@Slf4j
public class TypeAssuranceServiceImpl implements TypeAssuranceService{
	
	@Autowired
	private TypeAssuranceRepository typeRepository;

	@Override
	public TypeAssurance createType(TypeAssurance type) {
		
		return typeRepository.save(type);
	}

	@Override
	public List<TypeAssurance> getAll() {
		
		return typeRepository.findAll();
	}

	@Override
	public List<TypeAssurance> getTypeByUserId(Integer userId) {
		
		return typeRepository.findByUserId(userId);
	}


	@Override
	public TypeAssurance updateUser(TypeAssurance type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTypeAssurance(Integer id) {
		this.typeRepository.deleteById(id);
		
	}

	@Override
	public TypeAssurance updateType(TypeAssurance type) {
		
		return this.typeRepository.save(type);
	}

	@Override
	public TypeAssurance getType(Integer typeId) {
		return this.typeRepository.findById(typeId).get();
	}

}
