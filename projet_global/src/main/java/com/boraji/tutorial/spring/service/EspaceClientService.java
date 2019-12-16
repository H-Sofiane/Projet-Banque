package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.model.DemandeCompte;

public interface EspaceClientService {

	
	public DemandeCompte createDemandeCompte(Long idClient, String type, float solde);
	
		/* long save(DemandeCompte demandeCompte);
		DemandeCompte get(long id);
		   List<DemandeCompte> list();
		   void update(long id, DemandeCompte demandeCompte);
		   void delete(long id); */

}
