package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.CompteRemunerateur;

public interface CompteRemunerateurDao {
	long save(CompteRemunerateur compteRemunerateur);

	CompteRemunerateur get(long id);

	   List<CompteRemunerateur> list();

	   void update(long id, CompteRemunerateur compteRemunerateur);

	   void delete(long id);
}
