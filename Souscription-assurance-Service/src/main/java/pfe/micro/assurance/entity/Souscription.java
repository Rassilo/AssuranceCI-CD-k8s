package pfe.micro.assurance.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="_souscription")
public class Souscription {
	
	@Id
	@GeneratedValue
	private Integer souscriptionId;
	private String nom;
	private String prenom;
	private String email;
	private String situation_famille;
	private String categorie_Socioprofessionnelle;
	private String adresse;
	private String identifiant; 
	private String userId;
	private String etat_souscription;
	//durée de contrat en mois
	private Integer duree;
	private Integer typeId;
	private Integer assureurId;
	@Column(updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateCreation;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateDebutContrat;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateFinContrat;
	private String commentaire;
	//assurance auto
	private String immatriculation;
	private String marque_vehicule;
	private String type_Carburant;
	
	//assurance habitation 
	private String type_logement;
	private String surface_logement;
	
	

	@PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }
	
	
	public Souscription() {
		super();
	}


	public Souscription(String nom, String prenom, String email, String situation_famille,
			String categorie_Socioprofessionnelle, String adresse, String identifiant, String userId,
			String etat_souscription, Integer duree, Integer typeId, Integer assureurId, LocalDateTime dateCreation,
			LocalDateTime dateDebutContrat, LocalDateTime dateFinContrat, String commentaire, String immatriculation,
			String marque_vehicule, String type_Carburant, String type_logement, String surface_logement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.situation_famille = situation_famille;
		this.categorie_Socioprofessionnelle = categorie_Socioprofessionnelle;
		this.adresse = adresse;
		this.identifiant = identifiant;
		this.userId = userId;
		this.etat_souscription = etat_souscription;
		this.duree = duree;
		this.typeId = typeId;
		this.assureurId = assureurId;
		this.dateCreation = dateCreation;
		this.dateDebutContrat = dateDebutContrat;
		this.dateFinContrat = dateFinContrat;
		this.commentaire = commentaire;
		this.immatriculation = immatriculation;
		this.marque_vehicule = marque_vehicule;
		this.type_Carburant = type_Carburant;
		this.type_logement = type_logement;
		this.surface_logement = surface_logement;
		
	}


	public Souscription(Integer souscriptionId, String nom, String prenom, String email, String situation_famille,
			String categorie_Socioprofessionnelle, String adresse, String identifiant, String userId,
			String etat_souscription, Integer duree, Integer typeId, Integer assureurId, LocalDateTime dateCreation,
			LocalDateTime dateDebutContrat, LocalDateTime dateFinContrat, String commentaire, String immatriculation,
			String marque_vehicule, String type_Carburant, String type_logement, String surface_logement) {
		super();
		this.souscriptionId = souscriptionId;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.situation_famille = situation_famille;
		this.categorie_Socioprofessionnelle = categorie_Socioprofessionnelle;
		this.adresse = adresse;
		this.identifiant = identifiant;
		this.userId = userId;
		this.etat_souscription = etat_souscription;
		this.duree = duree;
		this.typeId = typeId;
		this.assureurId = assureurId;
		this.dateCreation = dateCreation;
		this.dateDebutContrat = dateDebutContrat;
		this.dateFinContrat = dateFinContrat;
		this.commentaire = commentaire;
		this.immatriculation = immatriculation;
		this.marque_vehicule = marque_vehicule;
		this.type_Carburant = type_Carburant;
		this.type_logement = type_logement;
		this.surface_logement = surface_logement;
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

	public Integer getSouscriptionId() {
		return souscriptionId;
	}
	
	public void setSouscriptionId(Integer souscriptionId) {
		this.souscriptionId = souscriptionId;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSituation_famille() {
		return situation_famille;
	}
	
	public void setSituation_famille(String situation_famille) {
		this.situation_famille = situation_famille;
	}
	
	public String getCategorie_Socioprofessionnelle() {
		return categorie_Socioprofessionnelle;
	}
	
	public void setCategorie_Socioprofessionnelle(String categorie_Socioprofessionnelle) {
		this.categorie_Socioprofessionnelle = categorie_Socioprofessionnelle;
	}
	
	public String getImmatriculation() {
		return immatriculation;
	}
	
	public void setImmatriculation(String immatriculation) {
		immatriculation = immatriculation;
	}
	
	public String getMarque_vehicule() {
		return marque_vehicule;
	}
	
	public void setMarque_vehicule(String marque_vehicule) {
		this.marque_vehicule = marque_vehicule;
	}
	
	public String getType_Carburant() {
		return type_Carburant;
	}
	
	public void setType_Carburant(String type_Carburant) {
		type_Carburant = type_Carburant;
	}
	
	public String getType_logement() {
		return type_logement;
	}
	
	public void setType_logement(String type_logement) {
		this.type_logement = type_logement;
	}
	
	
	
	public Integer getTypeId() {
		return typeId;
	}

	

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

	public String getEtat_souscription() {
		return etat_souscription;
	}



	public void setEtat_souscription(String etat_souscription) {
		this.etat_souscription = etat_souscription;
	}



	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}



	public String getSurface_logement() {
		return surface_logement;
	}



	public void setSurface_logement(String surface_logement) {
		this.surface_logement = surface_logement;
	}
	
	
	public Integer getDuree() {
		return duree;
	}


	public void setDuree(Integer duree) {
		this.duree = duree;
	}


	public LocalDateTime getDateDebutContrat() {
		return dateDebutContrat;
	}


	public void setDateDebutContrat(LocalDateTime dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}


	public LocalDateTime getDateFinContrat() {
		return dateFinContrat;
	}


	public void setDateFinContrat(LocalDateTime dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	

}
