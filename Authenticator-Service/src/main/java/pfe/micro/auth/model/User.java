package pfe.micro.auth.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="_user")
public class User{
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(unique = true)
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String cin;
	@Column(unique = true)
	private String passport;
	@Column(unique = true)
    private String resident;
	private String tel;
	private String datNaiss;
    private String adresse;
    private String profession;
    private String gouvernorat;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String password;
    private boolean etat = true;
    private String typeAssureur;
    private String photo;
    
    @Enumerated(value = EnumType.STRING)
    private Role role;
    
    @Enumerated(value = EnumType.STRING)
    private Sexe sexe;
    



	public User() {
		super();
	}



	
	


	public User(String nom, String prenom, String cin, String passport, String resident, String tel, String datNaiss,
			String adresse, String profession, String gouvernorat, String userName, String password, boolean etat,
			String typeAssureur, String photo, Role role, Sexe sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.passport = passport;
		this.resident = resident;
		this.tel = tel;
		this.datNaiss = datNaiss;
		this.adresse = adresse;
		this.profession = profession;
		this.gouvernorat = gouvernorat;
		this.userName = userName;
		this.password = password;
		this.etat = etat;
		this.typeAssureur = typeAssureur;
		this.photo = photo;
		this.role = role;
		this.sexe = sexe;
	}







	public User(Integer id, String nom, String prenom, String cin, String passport, String resident, String tel,
			String datNaiss, String adresse, String profession, String gouvernorat, String userName, String password,
			boolean etat, String typeAssureur, String photo, Role role, Sexe sexe) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.passport = passport;
		this.resident = resident;
		this.tel = tel;
		this.datNaiss = datNaiss;
		this.adresse = adresse;
		this.profession = profession;
		this.gouvernorat = gouvernorat;
		this.userName = userName;
		this.password = password;
		this.etat = etat;
		this.typeAssureur = typeAssureur;
		this.photo = photo;
		this.role = role;
		this.sexe = sexe;
	}







	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDatNaiss() {
		return datNaiss;
	}

	public void setDatNaiss(String datNaiss) {
		this.datNaiss = datNaiss;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}


	public boolean isEtat() {
		return etat;
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
	}


	public String getPassport() {
		return passport;
	}


	public void setPassport(String passport) {
		this.passport = passport;
	}


	public String getResident() {
		return resident;
	}


	public void setResident(String resident) {
		this.resident = resident;
	}


	public String getTypeAssureur() {
		return typeAssureur;
	}


	public void setTypeAssureur(String typeAssureur) {
		this.typeAssureur = typeAssureur;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}



	
}
