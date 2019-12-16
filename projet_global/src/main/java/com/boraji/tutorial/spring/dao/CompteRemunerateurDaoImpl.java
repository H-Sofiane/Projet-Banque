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

import com.boraji.tutorial.spring.model.CompteRemunerateur;

@Repository
public class CompteRemunerateurDaoImpl implements CompteRemunerateurDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(CompteRemunerateur compteRemunerateur) {
		sessionFactory.getCurrentSession().save(compteRemunerateur);
		return compteRemunerateur.getIdentifiant();
	}

	@Override
	public CompteRemunerateur get(long id) {
		
		return sessionFactory.getCurrentSession().get(CompteRemunerateur.class,id);
	}

	@Override
	public List<CompteRemunerateur> list() {
		Session session=sessionFactory.getCurrentSession();
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<CompteRemunerateur> cq=cb.createQuery(CompteRemunerateur.class);
		Root<CompteRemunerateur> root=cq.from(CompteRemunerateur.class);
		cq.select(root);
		Query<CompteRemunerateur> query=session.createQuery(cq);
	
		return query.getResultList();
	}

	@Override
	public void update(long id, CompteRemunerateur compteRemunerateur) {
		Session session= sessionFactory.getCurrentSession();
		CompteRemunerateur compte2=session.byId(CompteRemunerateur.class).load(id);
		compte2.setTauxRemuneration(compteRemunerateur.getTauxRemuneration());
		compte2.setSeuilminimum(compteRemunerateur.getSeuilminimum());
		
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session=sessionFactory.getCurrentSession();
		CompteRemunerateur compteRemunerateur=session.byId(CompteRemunerateur.class).load(id);
		session.delete(compteRemunerateur);

	}
}
