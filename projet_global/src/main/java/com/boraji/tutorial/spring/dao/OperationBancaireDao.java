package com.boraji.tutorial.spring.dao;

import java.util.List;


import com.boraji.tutorial.spring.model.OperationBancaire;

public interface OperationBancaireDao {
	   long save(OperationBancaire opperation);
	   OperationBancaire get(long id);
	   List<OperationBancaire> list();
	   void update(long id, OperationBancaire opperation);
	   void delete(long id);
}
