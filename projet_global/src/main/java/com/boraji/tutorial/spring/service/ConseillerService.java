package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.model.Client;
import com.boraji.tutorial.spring.model.Conseiller;

public interface ConseillerService {
	
	long save(Conseiller conseiller);
	Conseiller get(long id);
	   List<Conseiller> list();
	   void update(long id, Conseiller conseiller);
	   void delete(long id);
	
}
