package pfe.micro.assurance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="_contrat")
public class Contrat {
	
	@Id
	@GeneratedValue
	private Integer contratId;
	private String fileName;
	private String type;
	@Lob
	@Column(length=100000,columnDefinition="LONGBLOB")
	private byte[] data;
	private boolean etat;
	private Integer souscriptionId;
	
	
	
	
	public Contrat() {
		super();
	}


	public Contrat(String fileName, String type, byte[] data) {
		super();
		this.fileName = fileName;
		this.type = type;
		this.data = data;
	}
	
	
	public Contrat(String fileName, String type, byte[] data, boolean etat,Integer souscriptionId) {
		super();
		this.fileName = fileName;
		this.type = type;
		this.data = data;
		this.etat = etat;
		this.souscriptionId = souscriptionId;
	}


	
	public Contrat(Integer contratId, String fileName, String type, byte[] data, boolean etat,Integer souscriptionId) {
		super();
		this.contratId = contratId;
		this.fileName = fileName;
		this.type = type;
		this.data = data;
		this.etat = etat;
		this.souscriptionId = souscriptionId;
	}


	public Integer getContratId() {
		return contratId;
	}


	public void setContratId(Integer contratId) {
		this.contratId = contratId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}


	public boolean isEtat() {
		return etat;
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
	}


	public Integer getSouscriptionId() {
		return souscriptionId;
	}


	public void setSouscriptionId(Integer souscriptionId) {
		this.souscriptionId = souscriptionId;
	}

}

