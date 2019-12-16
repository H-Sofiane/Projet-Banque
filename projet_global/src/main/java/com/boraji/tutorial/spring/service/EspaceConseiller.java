package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.model.Client;
import com.boraji.tutorial.spring.model.Conseiller;

public interface EspaceConseiller {
	long save(Client client);
	Client get(long id);
	   List<Client> list();
	   void update(long id, Client client);
	   void delete(long id);
}
