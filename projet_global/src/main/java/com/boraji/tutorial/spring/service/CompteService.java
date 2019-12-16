package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.model.Compte;

public interface CompteService {
	
	long save(Compte compte);
	Compte get(long id);
	void update(long id, Compte compte);
	void delete(long id);

}
