package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.AdministrateurDao;

import com.boraji.tutorial.spring.model.Administrateur;

@Service
@Transactional(readOnly = true)
public class AdministrateurServiceImpl implements AdministrateurService {
	@Autowired
	private AdministrateurDao dao;

	@Override

	@Transactional
	public long save(Administrateur adminidtrateur) {
		return dao.save(adminidtrateur);
	}

	@Override
	public Administrateur get(long id) {
		return dao.get(id);
	}

	@Override
	public List<Administrateur> list() {
		return dao.list();
	}

	@Override
	@Transactional
	public void update(long id, Administrateur administrateur) {
		dao.update(id, administrateur);

	}

	@Override
	@Transactional
	public void delete(long id) {
		dao.delete(id);
	}

}
