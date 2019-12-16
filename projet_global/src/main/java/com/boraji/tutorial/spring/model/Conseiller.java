package com.boraji.tutorial.spring.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@DiscriminatorValue("conseiller")
public class Conseiller extends Utilisateur {

	private int matricule;
	private Date DateDebutContrat;
	
	@OneToMany(mappedBy="conseiller",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private Collection<Client>clients;
	
	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	private Administrateur administrateur;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<DemandeCompte> demandesCompte = new HashSet<DemandeCompte>();

	public int getMatricule() {
		return matricule;
	}

	public Set<DemandeCompte> getDemandesCompte() {
		return demandesCompte;
	}

	public void setDemandesCompte(Set<DemandeCompte> demandesCompte) {
		this.demandesCompte = demandesCompte;
	}
	
	public void addDemandeCompte(DemandeCompte demandeCompte) {
		this.demandesCompte.add(demandeCompte);
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public Date getDateDebutContrat() {
		return DateDebutContrat;
	}

	public void setDateDebutContrat(Date dateDebutContrat) {
		DateDebutContrat = dateDebutContrat;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}
	
	
	
	
	
	
}