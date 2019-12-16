package com.boraji.tutorial.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public class Compte implements Serializable{

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Identifiant;
	private int NumeroCompte;
	private Date dateCreation;
	private float Solde;
	private int RIB;
	@ManyToOne
	private Client client;	
	
	public long getIdentifiant() {
		return Identifiant;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setIdentifiant(long identifiant) {
		Identifiant = identifiant;
	}
	public int getNumeroCompte() {
		return NumeroCompte;
	}
	public void setNumeroCompte(int numeroCompte) {
		NumeroCompte = numeroCompte;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public float getSolde() {
		return Solde;
	}
	public void setSolde(float solde) {
		Solde = solde;
	}
	public int getRIB() {
		return RIB;
	}
	public void setRIB(int rIB) {
		RIB = rIB;
	}
	
	
	
	
}
