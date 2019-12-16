/*package com.boraji.tutorial.spring.controller;

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

import com.boraji.tutorial.spring.model.Client;
import com.boraji.tutorial.spring.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	   private ClientService clientService;

	   //---Ajouter un client---
	   @PostMapping("/client")
	   public ResponseEntity<?> save(@RequestBody Client client) {
	      long id = clientService.save(client);
	      return ResponseEntity.ok().body("Le nouveau client a été ajouté son ID est: " + id);
	   }

	   //---Récuperer un client via l'id---
	   @GetMapping("/client/{id}")
	   public ResponseEntity<Client> get(@PathVariable("id") long id) {
		   Client client = clientService.get(id);
	      return ResponseEntity.ok().body(client);
	   }

	   //---Récuperer tout les clients---
	   @GetMapping("/client")
	   public ResponseEntity<List<Client>> list() {
	      List<Client> clients = clientService.list();
	      return ResponseEntity.ok().body(clients);
	   }

	   //---Modifier un client via son id---
	   @PutMapping("/client/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Client client) {
	      clientService.update(id, client);
	      return ResponseEntity.ok().body("Book has been updated successfully.");
	   }

	   //---Supprimer le client via l'id---
	   @DeleteMapping("/client/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	     clientService.delete(id);
	      return ResponseEntity.ok().body("Book has been deleted successfully.");
	   }
	
}
*/