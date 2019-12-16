package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.model.Administrateur;
import com.boraji.tutorial.spring.model.Book;

public interface AdministrateurService {
	   long save(Administrateur adminidtrateur);
	   Administrateur get(long id);
	   List<Administrateur> list();
	   void update(long id, Administrateur administrateur);
	   void delete(long id);

}
