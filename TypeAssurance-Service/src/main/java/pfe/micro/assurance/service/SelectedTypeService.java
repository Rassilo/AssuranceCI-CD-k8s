package pfe.micro.assurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pfe.micro.assurance.entity.SelectedType;

@Service
public interface SelectedTypeService {
	
public SelectedType save(SelectedType selected);
	
	public void delete(Integer selectedtypeId);
	
	public SelectedType getSelectedType(Integer selectedtypeId);
	public SelectedType getSelectedTypebyUser(Integer userId);
	
	public List<SelectedType> getSelectedTypes();
	
	public SelectedType updateSelectedType(SelectedType selected);


}
