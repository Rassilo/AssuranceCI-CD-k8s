package pfe.micro.assurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.micro.assurance.entity.SelectedType;
import pfe.micro.assurance.repository.SelectedTypeRepository;
import pfe.micro.assurance.service.SelectedTypeService;

@Service
public class SelectedTypeServiceImpl implements SelectedTypeService{
	
	@Autowired
	private SelectedTypeRepository selectedTypeRepository;

	@Override
	public SelectedType save(SelectedType selected) {
		
		return selectedTypeRepository.save(selected);
	}

	

	@Override
	public SelectedType getSelectedType(Integer selectedtypeId) {
		
		return this.selectedTypeRepository.findSelectedTypeBySelectedtypeId(selectedtypeId);
	}

	@Override
	public List<SelectedType> getSelectedTypes() {
		
		return selectedTypeRepository.findAll();
	}



	@Override
	public void delete(Integer selectedtypeId) {
		
		this.selectedTypeRepository.deleteById(selectedtypeId);
	}



	@Override
	public SelectedType updateSelectedType(SelectedType selected) {
		
		return this.selectedTypeRepository.save(selected);
	}



	@Override
	public SelectedType getSelectedTypebyUser(Integer userId) {
		
		return this.selectedTypeRepository.findSelectedTypeByUserId(userId);
	}

	
}