package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.Administrateur;

public interface AdministrateurDao {
	   long save(Administrateur admin);

	   Administrateur get(long id);

	   List<Administrateur> list();

	   void update(long id, Administrateur admin);

	   void delete(long id);

}
