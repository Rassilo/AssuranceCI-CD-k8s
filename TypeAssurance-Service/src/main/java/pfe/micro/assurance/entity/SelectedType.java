package pfe.micro.assurance.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name="selected_type")
@Builder
public class SelectedType {
	
	@Id
	@GeneratedValue
	private Integer selectedtypeId;
	
	@Column(unique = true)
	private Integer userId;
	
	private List<String> listeTypes = new ArrayList<>();
	
	
	public SelectedType() {
		super();
	}
	
	public SelectedType(Integer selectedtypeId, Integer userId, List<String> listeTypes) {
		super();
		this.selectedtypeId = selectedtypeId;
		this.userId = userId;
		this.listeTypes = listeTypes;
	}





	public SelectedType(Integer userId, List<String> listeTypes) {
		super();
		this.userId = userId;
		this.listeTypes = listeTypes;
	}
	
	
	
	public Integer getSelectedtypeId() {
		return selectedtypeId;
	}
	public void setSelectedtypeId(Integer selectedtypeId) {
		this.selectedtypeId = selectedtypeId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<String> getListeTypes() {
		return listeTypes;
	}
	public void setListeTypes(List<String> listeTypes) {
		this.listeTypes = listeTypes;
	}

	

}