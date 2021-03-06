package com.boraji.tutorial.spring.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.model.Administrateur;
import com.boraji.tutorial.spring.model.Conseiller;
import com.boraji.tutorial.spring.model.DemandeCompte;
import com.boraji.tutorial.spring.service.AdministrateurService;
import com.boraji.tutorial.spring.service.ConseillerService;
import com.boraji.tutorial.spring.service.EspaceAdmin;

@RestController
public class EspaceAdminController {
	@Autowired
	   private ConseillerService conseillerService;
	
	@Autowired 
	EspaceAdmin espaceAdmin;

	   /*---Ajouter un conseiller---*/
	   @PostMapping("/conseiller")
	   public ResponseEntity<?> save(@RequestBody Conseiller conseiller) {
	      long id = conseillerService.save(conseiller);
	      return ResponseEntity.ok().body("Le nouveau conseiller a �t� ajout� son ID est: " + id);
	   }
	   
	   
	   
	   /*---Affecter une demande---*/
	   @PostMapping("/affectation")
	   public ResponseEntity<?> save(@RequestBody Conseiller conseiller, @RequestBody DemandeCompte demandeCompte) {
	      long idConseiller = conseiller.getId();
	      long idDemandeCompte = demandeCompte.getId();
		   Boolean response = espaceAdmin.affecterDemande(idConseiller, idDemandeCompte);
	      return ResponseEntity.ok().body(idConseiller + " " + idDemandeCompte);
	   }
	   

	   /*---R�cuperer un conseiller via l'id---*/
	   @GetMapping("/conseiller/{id}")
	   public ResponseEntity<Conseiller> get(@PathVariable("id") long id) {
		   Conseiller conseiller = conseillerService.get(id);
	      return ResponseEntity.ok().body(conseiller);
	   }

	   /*---R�cuperer tout les conseillers---*/
	   @GetMapping("/conseillers")
	   public ResponseEntity<List<Conseiller>> list() {
	      List<Conseiller> conseillers = conseillerService.list();
	      return ResponseEntity.ok().body(conseillers);
	   }

	   /*---Modifier un conseiller via son id---*/
	   @PutMapping("/conseiller/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Conseiller conseiller) {
	      conseillerService.update(id, conseiller);
	      return ResponseEntity.ok().body("Book has been updated successfully.");
	   }

	   /*---Supprimer le conseiller via l'id---*/
	   @DeleteMapping("/conseiller/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      conseillerService.delete(id);
	      return ResponseEntity.ok().body("Book has been deleted successfully.");
	   }
	   
	   
}
