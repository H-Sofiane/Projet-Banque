package com.boraji.tutorial.spring.dao;

import java.util.List;


import com.boraji.tutorial.spring.model.DemandeCompte;

public interface DemandeCompteDao {
	long saveDemandeCompte( DemandeCompte  demandeCompte);

	 DemandeCompte get(long id);

	   List< DemandeCompte> list();

	   void update(long id,  DemandeCompte  demandeCompte);

	   void delete(long id);
}
