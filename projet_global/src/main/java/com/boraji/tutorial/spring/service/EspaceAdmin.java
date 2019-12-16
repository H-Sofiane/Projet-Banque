package com.boraji.tutorial.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.model.Client;
import com.boraji.tutorial.spring.model.Conseiller;
import com.boraji.tutorial.spring.model.DemandeCompte;

public interface EspaceAdmin {

	/*
	 * List<Conseiller> list(Conseiller conseillers); List<DemandeCompte>
	 * list(DemandeCompte demandeComptes);
	 */

	long save(Conseiller conseiller);

	Conseiller get(long id);

	List<Conseiller> list();

	void update(long id, Conseiller conseiller);

	void delete(long id);

	long saveDemandeCompte(DemandeCompte demandeCompte);

	DemandeCompte getDemandeCompte(long id);

	public Boolean affecterDemande(long idConseiller, long idDemandeCompte);

	public Set<DemandeCompte> getAllDemandeCompte();

}
