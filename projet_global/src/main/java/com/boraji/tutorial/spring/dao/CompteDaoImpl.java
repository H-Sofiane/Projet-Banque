package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.boraji.tutorial.spring.model.Compte;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
public class CompteDaoImpl implements CompteDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Compte compte) {
		sessionFactory.getCurrentSession().save(compte);
		return compte.getIdentifiant();
	}

	@Override
	public Compte get(long id) {
		
		return sessionFactory.getCurrentSession().get(Compte.class,id);
	}

	@Override
	public List<Compte> list() {
		Session session=sessionFactory.getCurrentSession();
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Compte> cq=cb.createQuery(Compte.class);
		Root<Compte> root=cq.from(Compte.class);
		cq.select(root);
		Query<Compte> query=session.createQuery(cq);
	
		return query.getResultList();
	}

	@Override
	public void update(long id, Compte compte) {
		Session session= sessionFactory.getCurrentSession();
		Compte compte2=session.byId(Compte.class).load(id);
		compte2.setSolde(compte.getSolde());
		compte2.setDateCreation(compte.getDateCreation());
		compte2.setIdentifiant(compte.getIdentifiant());
		compte2.setNumeroCompte(compte.getNumeroCompte());
		compte2.setRIB(compte.getRIB());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session=sessionFactory.getCurrentSession();
		Compte compte=session.byId(Compte.class).load(id);
		session.delete(compte);

	}

}
