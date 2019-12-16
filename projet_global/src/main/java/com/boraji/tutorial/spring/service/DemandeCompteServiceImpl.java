package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.DemandeCompteDao;
import com.boraji.tutorial.spring.model.DemandeCompte;

@Service
@Transactional(readOnly = true)
public class DemandeCompteServiceImpl implements DemandeCompteService {
	@Autowired
	 private DemandeCompteDao demandeComptedao;
	@Override
	
	@Transactional
	public long save(DemandeCompte demandeCompte) {
		 return demandeComptedao.saveDemandeCompte(demandeCompte);
	}

	@Override
	public DemandeCompte get(long id) {
		return demandeComptedao.get(id);
	}

	@Override
	public List<DemandeCompte> list() {
		 return demandeComptedao.list();
	}

	@Override
	@Transactional
	public void update(long id, DemandeCompte demandeCompte) {
		demandeComptedao.update(id, demandeCompte);
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		demandeComptedao.delete(id);
	}
}
