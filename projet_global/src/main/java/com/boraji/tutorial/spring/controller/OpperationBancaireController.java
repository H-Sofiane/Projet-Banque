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
import com.boraji.tutorial.spring.model.OperationBancaire;
import com.boraji.tutorial.spring.service.BookService;
import com.boraji.tutorial.spring.service.OpperationBancaireService;
@RestController
public class OpperationBancaireController {
	@Autowired
	   private OpperationBancaireService oppService;

	   /*---Add new Opperation---*/
	   @PostMapping("/opperation")
	   public ResponseEntity<?> save(@RequestBody OperationBancaire opp) {
	      long id = oppService.save(opp);
	      return ResponseEntity.ok().body("New Operation bancaire has been saved with ID:" + id);
	   }

	   /*---Get a book by id---*/
	   @GetMapping("/opperation/{id}")
	   public ResponseEntity<OperationBancaire> get(@PathVariable("id") long id) {
	      OperationBancaire opp = oppService.get(id);
	      return ResponseEntity.ok().body(opp);
	   }

	   /*---get all books---*/
	   @GetMapping("/opperation")
	   public ResponseEntity<List<OperationBancaire>> list() {
	      List<OperationBancaire> opps = oppService.list();
	      return ResponseEntity.ok().body(opps);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/opperation/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody OperationBancaire opp) {
	      oppService.update(id, opp);
	      System.out.println("date: "+ opp.getDateVirement());
	      return ResponseEntity.ok().body("Opperation Bancaire has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/opperation/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      oppService.delete(id);
	      return ResponseEntity.ok().body("Operation Bancaire has been deleted successfully.");
	   }

}
