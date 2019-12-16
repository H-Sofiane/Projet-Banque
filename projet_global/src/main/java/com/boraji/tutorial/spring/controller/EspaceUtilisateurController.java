package com.boraji.tutorial.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.model.Client;
import com.boraji.tutorial.spring.model.Compte;
import com.boraji.tutorial.spring.model.Conseiller;
import com.boraji.tutorial.spring.model.DemandeCompte;
import com.boraji.tutorial.spring.model.Utilisateur;
import com.boraji.tutorial.spring.service.DemandeCompteService;
import com.boraji.tutorial.spring.service.EspaceAdmin;
import com.boraji.tutorial.spring.service.UtilisateurService;

@RestController
public class EspaceUtilisateurController {
	
	@Autowired 
	DemandeCompteService demandeCompteService;
	
	@Autowired 
	UtilisateurService utilisateurService;
	
	/*---Faire une demande de compte---*/
	   @PostMapping("/demandeCompte")
	   public ResponseEntity<?> save(@RequestBody DemandeCompte demandeCompte) {
	      long id = demandeCompteService.save(demandeCompte);
	      return ResponseEntity.ok().body("La demande de compte a été faite avec succès");
	   }
	   
	  /* @PostMapping("/affectation")
	   public ResponseEntity<?> save(@RequestBody Client client, @RequestBody Compte compte) {
	      long idClient = client.getId();
		   Boolean response = espaceAdmin.affecterDemande(idClient, compte);
	      return ResponseEntity.ok().body(idConseiller + " " + idDemandeCompte);
	   }*/

}
