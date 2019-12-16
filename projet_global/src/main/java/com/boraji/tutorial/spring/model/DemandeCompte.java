package com.boraji.tutorial.spring.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DemandeCompte {
	@Id @GeneratedValue
	private long id;
	private String nom;
	private String prenom;
	private String adress;
	private String mail;
	private int tel;
	private Boolean isAffected;
	private Boolean isValid;
	private Date dateAffectation;
	private String Status;
	
	@OneToOne
	private Compte nouveauCompte;
	
	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Boolean getIsAffected() {
		return isAffected;
	}

	public void setIsAffected(Boolean isAffected) {
		this.isAffected = isAffected;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
    private Administrateur administrateur;
	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public DemandeCompte() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public DemandeCompte(String nom, String prenom, String adress, String mail, int tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.mail = mail;
		this.tel = tel;
	}
	
	public Compte getNouveauCompte() {
		return nouveauCompte;
	}

	public void setNouveauCompte(Compte nouveauCompte) {
		this.nouveauCompte = nouveauCompte;
	}

}
