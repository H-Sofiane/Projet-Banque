package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.BookDao;
import com.boraji.tutorial.spring.dao.UtilisateurDao;
import com.boraji.tutorial.spring.model.Utilisateur;

@Service
@Transactional(readOnly = true)
public class UtilisateurServiceImpl implements UtilisateurService {

	 @Autowired
	   private UtilisateurDao utilisateurDao;

	   @Transactional
	   @Override
	   public long save(Utilisateur utilisateur) {
	      return utilisateurDao.save(utilisateur);
	   }

	   @Override
	   public Utilisateur get(long id) {
	      return utilisateurDao.get(id);
	   }

	   @Override
	   public List<Utilisateur> list() {
	      return utilisateurDao.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Utilisateur utilisateur) {
	      utilisateurDao.update(id, utilisateur);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
	      utilisateurDao.delete(id);
	   }

	@Override
	public void deleteAll(Utilisateur utilisateurs) {
		
		utilisateurDao.deleteAll(utilisateurs);
		
	}
	
}
