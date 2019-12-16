package com.boraji.tutorial.spring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.CompteDao;
import com.boraji.tutorial.spring.model.Compte;


@Service
@Transactional(readOnly = true)
public class CompteServiceImpl implements CompteService {

	@Autowired
	private CompteDao compteDao;
	
	@Transactional
	@Override
	public long save(Compte compte) {
		return compteDao.save(compte);
	}

	@Override
	public Compte get(long id) {
		return compteDao.get(id);
	}

	@Transactional
	@Override
	public void update(long id, Compte compte) {
		compteDao.update(id,compte);

	}

	@Transactional
	@Override
	public void delete(long id) {
		compteDao.delete(id);

	}

}
