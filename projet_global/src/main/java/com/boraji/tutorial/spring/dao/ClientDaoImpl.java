package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring.model.Client;

@Repository
public class ClientDaoImpl implements ClientDao {
	
	@Autowired
	   private SessionFactory sessionFactory;

	   @Override
	   public long save(Client client) {
	      sessionFactory.getCurrentSession().save(client);
	      return client.getId();
	   }

	   @Override
	   public Client get(long id) {
	      return sessionFactory.getCurrentSession().get(Client.class, id);
	   }

	   @Override
	   public List<Client> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Client> cq = cb.createQuery(Client.class);
	      Root<Client> root = cq.from(Client.class);
	      cq.select(root);
	      Query<Client> query = session.createQuery(cq);
	      return query.getResultList();
	   }

	   @Override
	   public void update(long id, Client client) {
	      Session session = sessionFactory.getCurrentSession();
	      Client client2 = session.byId(Client.class).load(id);
	      client2.setSituationmatrimoniale(client.getSituationmatrimoniale());
	      client2.setNbEnfant(client.getNbEnfant());
	      session.flush();
	   }

	   @Override
	   public void delete(long id) {
	      Session session = sessionFactory.getCurrentSession();
	      Client conseiller = session.byId(Client.class).load(id);
	      session.delete(conseiller);
	   }
	
}
