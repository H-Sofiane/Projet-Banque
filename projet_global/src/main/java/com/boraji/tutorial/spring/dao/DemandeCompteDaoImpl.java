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

import com.boraji.tutorial.spring.model.DemandeCompte;

@Repository
public class DemandeCompteDaoImpl implements DemandeCompteDao {
	 @Autowired
	   private SessionFactory sessionFactory;

	   @Override
	   public long saveDemandeCompte(DemandeCompte demandeCompte) {
	      sessionFactory.getCurrentSession().save(demandeCompte);
	      return demandeCompte.getId();
	   }

	   @Override
	   public DemandeCompte get(long id) {
	      return sessionFactory.getCurrentSession().get(DemandeCompte.class, id);
	   }

	   @Override
	   public List<DemandeCompte> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<DemandeCompte> cq = cb.createQuery(DemandeCompte.class);
	      Root<DemandeCompte> root = cq.from(DemandeCompte.class);
	      cq.select(root);
	      Query<DemandeCompte> query = session.createQuery(cq);
	      return query.getResultList();
	   
	   }
	   @Override
	   public void update(long id, DemandeCompte admin) {
	      Session session = sessionFactory.getCurrentSession();
	      DemandeCompte admin2 = session.byId(DemandeCompte.class).load(id);
	      admin2.setMail(admin.getMail());	
	      session.flush();
	   }

	   @Override
	   public void delete(long id) {
	      Session session = sessionFactory.getCurrentSession();
	      DemandeCompte admin = session.byId(DemandeCompte.class).load(id);
	      session.delete(admin);
	   }
}
