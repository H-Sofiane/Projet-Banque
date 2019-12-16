package com.boraji.tutorial.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@DiscriminatorValue("client")
public class Client extends Utilisateur{



	private String situationmatrimoniale;
	private int nbEnfant;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="client")
	@Fetch(FetchMode.SUBSELECT)
	private List<Compte> comptes = new ArrayList<Compte>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="client")
	@Fetch(FetchMode.SUBSELECT)
	private List<DemandeCompte> demandesCompte = new ArrayList<DemandeCompte>();
		
	
	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	private Conseiller conseiller;

	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public String getSituationmatrimoniale() {
		return situationmatrimoniale;
	}
	public void setSituationmatrimoniale(String situationmatrimoniale) {
		this.situationmatrimoniale = situationmatrimoniale;
	}
	public int getNbEnfant() {
		return nbEnfant;
	}
	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}
	public Client(String adresse, String situationmatrimoniale, int nbEnfant) {
		super();
		this.adresse = adresse;
		this.situationmatrimoniale = situationmatrimoniale;
		this.nbEnfant = nbEnfant;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<DemandeCompte> getDemandesCompte() {
		return demandesCompte;
	}
	public void setDemandesCompte(List<DemandeCompte> demandesCompte) {
		this.demandesCompte = demandesCompte;
	}

}
