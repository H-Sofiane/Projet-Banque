package com.boraji.tutorial.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.CompteRemunerateurDao;
import com.boraji.tutorial.spring.model.CompteRemunerateur;

@Service
@Transactional(readOnly = true)
public class CompteRemunerateurServiceImpl implements CompteRemunerateurService {
	@Autowired
	private CompteRemunerateurDao compteRemunerateurDao;
	
	@Transactional
	@Override
	public long save(CompteRemunerateur compteRemunerateur) {
		return compteRemunerateurDao.save(compteRemunerateur);
	}

	@Override
	public CompteRemunerateur get(long id) {
		return compteRemunerateurDao.get(id);
	}

	@Transactional
	@Override
	public void update(long id, CompteRemunerateur compteRemunerateur) {
		compteRemunerateurDao.update(id,compteRemunerateur);

	}

	@Transactional
	@Override
	public void delete(long id) {
		compteRemunerateurDao.delete(id);

	}
}
