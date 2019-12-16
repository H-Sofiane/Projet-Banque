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

import com.boraji.tutorial.spring.model.Utilisateur;

@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {

	@Autowired
	   private SessionFactory sessionFactory;

	   @Override
	   public long save(Utilisateur utilisateur) {
	      sessionFactory.getCurrentSession().save(utilisateur);
	      return utilisateur.getId();
	   }

	   @Override
	   public Utilisateur get(long id) {
	      return sessionFactory.getCurrentSession().get(Utilisateur.class, id);
	   }

	   @Override
	   public List<Utilisateur> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Utilisateur> cq = cb.createQuery(Utilisateur.class);
	      Root<Utilisateur> root = cq.from(Utilisateur.class);
	      cq.select(root);
	      Query<Utilisateur> query = session.createQuery(cq);
	      return query.getResultList();
	   }

	   @Override
	   public void update(long id, Utilisateur utilisateur) {
	      Session session = sessionFactory.getCurrentSession();
	      Utilisateur utilisateur2 = session.byId(Utilisateur.class).load(id);
	      utilisateur2.setNom(utilisateur.getNom());
	      utilisateur2.setPrenom(utilisateur.getPrenom());
	      utilisateur2.setMail(utilisateur.getMail());
	      utilisateur2.setAdresse(utilisateur.getAdresse());
	      utilisateur2.setTelephone(utilisateur.getTelephone());
	      utilisateur2.setPseudonyme(utilisateur.getPseudonyme());
	      utilisateur2.setMdp(utilisateur.getMdp());
	      session.flush();
	   }

	   @Override
	   public void delete(long id) {
	      Session session = sessionFactory.getCurrentSession();
	      Utilisateur utilisateur = session.byId(Utilisateur.class).load(id);
	      session.delete(utilisateur);
	   }

	@Override
	public void deleteAll(Utilisateur utilisateurs) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(utilisateurs);
		
	}
	
}
