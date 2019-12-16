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

import com.boraji.tutorial.spring.model.Book;
import com.boraji.tutorial.spring.model.Compte;
import com.boraji.tutorial.spring.service.CompteService;

@RestController
public class CompteController {

	@Autowired
	private CompteService compteService;

	/*--- Add new compte---*/
	@PostMapping("/compte")
	public ResponseEntity<?> save(@RequestBody Compte compte) {
		long id = compteService.save(compte);
		return ResponseEntity.ok().body("New compte has been saved with ID:" + id);
	}

	/*---Get a compte by id---*/
	@GetMapping("/compte/{id}")
	public ResponseEntity<Compte> get(@PathVariable("id") int id) {
		Compte compte = compteService.get(id);
		return ResponseEntity.ok().body(compte);
	}

	
	 /*---get all comptes---*/
	 //  @GetMapping("/compte")
	 //  public ResponseEntity<List<Compte>> list() {
	 //     List<Compte> comptes = CompteService.list();
	 //     return ResponseEntity.ok().body(books);
	 //  }
	
	/*---Update a book by id---*/
	   @PutMapping("/compte/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Compte compte) {
	      compteService.update(compte.getIdentifiant(), compte);
	      return ResponseEntity.ok().body("Compte has been updated successfully.");
	   }
	   /*---Delete a book by id---*/
	   @DeleteMapping("/compte/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      compteService.delete(id);
	      return ResponseEntity.ok().body("Compte has been deleted successfully.");
	   }
	
}
