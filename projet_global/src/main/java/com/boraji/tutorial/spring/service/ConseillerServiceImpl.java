package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.ClientDao;
import com.boraji.tutorial.spring.dao.ConseillerDao;
import com.boraji.tutorial.spring.model.Client;
import com.boraji.tutorial.spring.model.Conseiller;

@Service
@Transactional(readOnly = true)
public class ConseillerServiceImpl implements ConseillerService {

	@Autowired
	   private ConseillerDao conseillerDao;
	
	@Autowired
	   private ClientDao clientDao;

	   @Transactional
	   @Override
	   public long save(Conseiller conseiller) {
	      return conseillerDao.save(conseiller);
	   }

	   @Transactional
	   @Override
	   public Conseiller get(long id) {
	      return conseillerDao.get(id);
	   }

	   @Transactional
	   @Override
	   public List<Conseiller> list() {
	      return conseillerDao.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Conseiller conseiller) {
	      conseillerDao.update(id, conseiller);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
	      conseillerDao.delete(id);
	   }
	
}
