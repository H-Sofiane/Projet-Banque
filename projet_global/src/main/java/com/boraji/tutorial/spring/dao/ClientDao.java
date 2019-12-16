package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.Client;

public interface ClientDao {
	long save(Client client);

	Client get(long id);

	   List<Client> list();

	   void update(long id, Client client);

	   void delete(long id);
}
