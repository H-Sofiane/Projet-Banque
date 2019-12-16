package com.boraji.tutorial.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.ClientDao;
import com.boraji.tutorial.spring.dao.UtilisateurDao;
import com.boraji.tutorial.spring.model.Client;
import com.boraji.tutorial.spring.model.Compte;
import com.boraji.tutorial.spring.model.CompteDecouvert;
import com.boraji.tutorial.spring.model.CompteRemunerateur;
import com.boraji.tutorial.spring.model.DemandeCompte;
import com.boraji.tutorial.spring.model.Utilisateur;

@Service
@Transactional(readOnly = true)
public class EspaceClientImpl {
	
	@Autowired
	ClientDao clientDao;
	
	@Autowired
	UtilisateurDao utilisateurDao;
	
	
	
	public DemandeCompte createDemandeCompte(Long idClient, String type, float solde) {
		Client client = clientDao.get(idClient);
		
		DemandeCompte demandeCompte = new DemandeCompte();
		
		if (type.equals("compte courant")) {
			System.out.println("Compte courant");
			Compte compte = new Compte();
			compte.setSolde(solde);
			
			demandeCompte.setNouveauCompte(compte);
			client.getComptes().add(compte);
			client.getDemandesCompte().add(demandeCompte);		
		}
		else if (type.equals("compte rémunerateur"))
		{
			System.out.println("Compte rémunerateur");
			CompteRemunerateur compteRemunerateur = new CompteRemunerateur();
			compteRemunerateur.setSolde(solde);
			client.getDemandesCompte().add(demandeCompte);
		}
		else
		{
			System.out.println("Compte découvert");
			CompteDecouvert compteDecouvert = new CompteDecouvert();
			compteDecouvert.setSolde(solde);
			client.getDemandesCompte().add(demandeCompte);
		}
		return demandeCompte;
	}

}
