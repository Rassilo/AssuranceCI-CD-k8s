package pfe.micro.assurance.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="_renouvellement")
public class DemandeRenouvellement {
	
	@Id
	@GeneratedValue
	private Integer renouvellementId;
	private String decision;
	private Integer souscriptionId;
	private Integer assureurId;
	private Integer duree;
	private String motif;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateCreation;
	
	@PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }
	
	
	

	public DemandeRenouvellement() {
		super();
	}




	




	public DemandeRenouvellement(String decision, Integer souscriptionId, Integer assureurId,
			LocalDateTime dateCreation,String motif,Integer duree) {
		super();
		this.decision = decision;
		this.souscriptionId = souscriptionId;
		this.assureurId = assureurId;
		this.dateCreation = dateCreation;
		this.motif = motif;
		this.duree = duree;
	}




	public DemandeRenouvellement(Integer renouvellementId, String decision, Integer souscriptionId, Integer assureurId,
			LocalDateTime dateCreation,String motif,Integer duree) {
		super();
		this.renouvellementId = renouvellementId;
		this.decision = decision;
		this.souscriptionId = souscriptionId;
		this.assureurId = assureurId;
		this.dateCreation = dateCreation;
		this.motif = motif;
		this.duree = duree;
	}

	


	public Integer getRenouvellementId() {
		return renouvellementId;
	}

	public void setRenouvellementId(Integer renouvellementId) {
		this.renouvellementId = renouvellementId;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public Integer getSouscriptionId() {
		return souscriptionId;
	}

	public void setSouscriptionId(Integer souscriptionId) {
		this.souscriptionId = souscriptionId;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}




	public Integer getAssureurId() {
		return assureurId;
	}




	public void setAssureurId(Integer assureurId) {
		this.assureurId = assureurId;
	}




	public String getMotif() {
		return motif;
	}




	public void setMotif(String motif) {
		this.motif = motif;
	}




	public Integer getDuree() {
		return duree;
	}




	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	
	
	

}
