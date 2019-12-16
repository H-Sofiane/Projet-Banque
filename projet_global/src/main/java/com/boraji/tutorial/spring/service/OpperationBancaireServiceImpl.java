package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.BookDao;
import com.boraji.tutorial.spring.dao.OperationBancaireDao;
import com.boraji.tutorial.spring.model.OperationBancaire;
@Service
@Transactional(readOnly = true)
public class OpperationBancaireServiceImpl implements OpperationBancaireService {
	@Autowired
	   private OperationBancaireDao dao;
	
	 @Transactional
	@Override
	public long save(OperationBancaire opperation) {
		
		return dao.save(opperation);
	}

	@Override
	public OperationBancaire get(long id) {
	
		return dao.get(id);
	}

	@Override
	public List<OperationBancaire> list() {
		
		return dao.list();
	}
   @Transactional
	@Override
	public void update(long id, OperationBancaire opperation) {
		dao.update(id, opperation);
		
	}
  @Transactional
	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

}
