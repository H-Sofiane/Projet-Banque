package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.Utilisateur;

public interface UtilisateurDao {

	 long save(Utilisateur utilisateur);

	 Utilisateur get(long id);

	   List<Utilisateur> list();

	   void update(long id, Utilisateur utilisateur);

	   void delete(long id);

	   void deleteAll(Utilisateur utilisateurs);
}
