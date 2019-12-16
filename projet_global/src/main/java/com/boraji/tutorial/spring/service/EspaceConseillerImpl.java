package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.ClientDao;
import com.boraji.tutorial.spring.model.Client;

@Service
@Transactional(readOnly = true)
public class EspaceConseillerImpl implements EspaceConseiller {
	@Autowired
	   private ClientDao clientDao;

	   @Transactional
	   @Override
	   public long save(Client client) {
	      return clientDao.save(client);
	   }

	   @Transactional
	   @Override
	   public Client get(long id) {
	      return clientDao.get(id);
	   }
	   
	   @Transactional
	   @Override
	   public List<Client> list() {
	      return clientDao.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Client client) {
	      clientDao.update(id, client);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
	      clientDao.delete(id);
	   }
}
