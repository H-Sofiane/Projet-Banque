package com.boraji.tutorial.spring.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@DiscriminatorValue("administrateur")
public class Administrateur extends Utilisateur {
	
	
	@OneToMany(mappedBy="administrateur",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private Collection<Conseiller>conseillers;
	@OneToMany(mappedBy="administrateur",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private Collection<DemandeCompte> demandes;

	public Collection<DemandeCompte> getDemandes() {
		return demandes;
	}

	public void setDemandes(Collection<DemandeCompte> demandes) {
		this.demandes = demandes;
	}

	public Administrateur() {
		super();
	}

	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
	

}
