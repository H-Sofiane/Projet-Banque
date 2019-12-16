package com.boraji.tutorial.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.model.Administrateur;
import com.boraji.tutorial.spring.model.Book;
import com.boraji.tutorial.spring.service.AdministrateurService;
import com.boraji.tutorial.spring.service.BookService;
@RestController
public class AdministrateurController {
	@Autowired //permet de faire l'injection de dépendances entre les beans de l'application
	   private AdministrateurService admistrateurService;

	   /*---Add new administrateur---*/
	   @PostMapping("/administrateur")
	   public ResponseEntity<?> save(@RequestBody Administrateur administrateur) {
	      long id = admistrateurService.save(administrateur);
	      return ResponseEntity.ok().body("New Administrateur has been saved with ID:" + administrateur.getId() + administrateur.getNom()+administrateur.getPrenom()+administrateur.getAdresse()+administrateur.getMail());
	   }

	   /*---Get a book by id---*/
	   @GetMapping("/administrateur/{id}")
	   public ResponseEntity<Administrateur> get(@PathVariable("id") long id) {
	      Administrateur administrateur = admistrateurService.get(id);
	      return ResponseEntity.ok().body(administrateur);
	   }

	   /*---get all administrateurs---*/
	   @GetMapping("/administrateur")
	   public ResponseEntity<List<Administrateur>> list() {
	      List<Administrateur> administrateurs = admistrateurService.list();
	      return ResponseEntity.ok().body(administrateurs);
	   }

	   /*---Update a administrateur by id---*/
	   @PutMapping("/administrateur/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Administrateur administrateur) {
	      admistrateurService.update(id, administrateur);
	      return ResponseEntity.ok().body("Administrateur has been updated successfully.");
	   }

	   /*---Delete a administrateurby id---*/
	   @DeleteMapping("/administrateur/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	     admistrateurService.delete(id);
	      return ResponseEntity.ok().body("Administrateur has been deleted successfully.");
	   }
}
