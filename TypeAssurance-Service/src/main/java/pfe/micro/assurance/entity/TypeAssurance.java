package pfe.micro.assurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="_typeAssurance")
public class TypeAssurance {
	
	@Id
	@GeneratedValue
	private Integer typeId;
	private String typeName;
	private String typeDescription;
	private Integer userId;
	
	
	
	public TypeAssurance() {
		super();
	}
	public TypeAssurance(Integer typeId, String typeName, String typeDescription, Integer userId) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeDescription = typeDescription;
		this.userId = userId;
	}
	public TypeAssurance(String typeName, String typeDescription, Integer userId) {
		super();
		this.typeName = typeName;
		this.typeDescription = typeDescription;
		this.userId = userId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDescription() {
		return typeDescription;
	}
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
}