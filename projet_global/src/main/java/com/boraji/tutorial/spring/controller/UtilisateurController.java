package com.boraji.tutorial.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.model.Utilisateur;
import com.boraji.tutorial.spring.service.UtilisateurService;

@RestController
public class UtilisateurController {
	
	@Autowired
	   private UtilisateurService utilisateurService;

	   /*---Ajouter un utilisateur---*/
	   @PostMapping("/utilisateur")
	   @CrossOrigin(origins = "http://localhost:4200")
	   public ResponseEntity<?> save(@RequestBody Utilisateur utilisateur) {
	      long id = utilisateurService.save(utilisateur);
	      return ResponseEntity.ok().body("Un nouvel utilisateur a été ajouté son ID est: " + id);
	   }

	   /*---Récuperer un utilisateur via son id---*/
	   @GetMapping("/utilisateur/{id}")
	   @CrossOrigin(origins = "http://localhost:4200")
	   public ResponseEntity<Utilisateur> get(@PathVariable("id") long id) {
		   Utilisateur utilisateur = utilisateurService.get(id);
	      return ResponseEntity.ok().body(utilisateur);
	   }

	   /*---Récuperer tout les utilisateurs---*/
	   @GetMapping("/utilisateurs")
	   @CrossOrigin(origins = "http://localhost:4200")
	   public ResponseEntity<List<Utilisateur>> list() {
	      List<Utilisateur> utilisateurs = utilisateurService.list();
	      return ResponseEntity.ok().body(utilisateurs);
	   }

	   /*---Modifier un utilisateur via son id---*/
	   @PutMapping("/utilisateur/{id}")
	   @CrossOrigin(origins = "http://localhost:4200")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Utilisateur utilisateur) {
		   utilisateurService.update(id, utilisateur);
	      return ResponseEntity.ok().body("L'utilisateur a été modifié avec succès.");
	   }

	   /*---Supprimer l'utilisateur via l'id---*/
	   @DeleteMapping("/utilisateur/{id}")
	   @CrossOrigin(origins = "http://localhost:4200")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      utilisateurService.delete(id);
	      return ResponseEntity.ok().body("L'utilisateur a été supprimé avec succès.");
	   }
	   
	   /*---Supprimer l'utilisateur via l'id---*/
	   @DeleteMapping("/utilisateurs")
	   @CrossOrigin(origins = "http://localhost:4200")
	   public ResponseEntity<?> deleteAll(Utilisateur utilisateurs) {
	      utilisateurService.deleteAll(utilisateurs);
	      return ResponseEntity.ok().body("L'utilisateur a été supprimé avec succès.");
	   }

}
