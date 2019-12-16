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

import com.boraji.tutorial.spring.model.Conseiller;

@Repository
public class ConseillerDaoImpl implements ConseillerDao {

	@Autowired
	   private SessionFactory sessionFactory;

	   @Override
	   public long save(Conseiller conseiller) {
	      sessionFactory.getCurrentSession().save(conseiller);
	      return conseiller.getId();
	   }

	   @Override
	   public Conseiller get(long id) {
	      return sessionFactory.getCurrentSession().get(Conseiller.class, id);
	   }

	   @Override
	   public List<Conseiller> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Conseiller> cq = cb.createQuery(Conseiller.class);
	      Root<Conseiller> root = cq.from(Conseiller.class);
	      cq.select(root);
	      Query<Conseiller> query = session.createQuery(cq);
	      return query.getResultList();
	   }

	   @Override
	   public void update(long id, Conseiller conseiller) {
	      Session session = sessionFactory.getCurrentSession();
	      Conseiller conseiller2 = session.byId(Conseiller.class).load(id);
	      conseiller2.setMatricule(conseiller.getMatricule());
	     // conseiller2.setDateDebutContrat(conseiller.getDateDebutContrat());
	      session.flush();
	   }

	   @Override
	   public void delete(long id) {
	      Session session = sessionFactory.getCurrentSession();
	      Conseiller conseiller = session.byId(Conseiller.class).load(id);
	      session.delete(conseiller);
	   }
	
}
