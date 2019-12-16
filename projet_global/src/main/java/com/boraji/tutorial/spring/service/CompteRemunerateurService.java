package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.model.CompteRemunerateur;

public interface CompteRemunerateurService {
	long save(CompteRemunerateur compteRemunerateur);
	CompteRemunerateur get(long id);
	void update(long id, CompteRemunerateur compteRemunerateur);
	void delete(long id);

}
