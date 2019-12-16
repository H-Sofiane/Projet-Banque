package com.boraji.tutorial.spring.dao;

import java.util.List;
import com.boraji.tutorial.spring.model.Compte;

public interface CompteDao {

	long save(Compte compte);
	Compte get(long id);
	List<Compte> list();
	void update(long id, Compte compte);
	void delete(long id);
	
}
