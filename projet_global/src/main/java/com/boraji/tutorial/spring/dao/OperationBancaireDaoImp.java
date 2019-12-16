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

import com.boraji.tutorial.spring.model.*;

@Repository
public class OperationBancaireDaoImp implements OperationBancaireDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(OperationBancaire opperation) {

		sessionFactory.getCurrentSession().save(opperation);
		return opperation.getNumero();
	}

	@Override
	public OperationBancaire get(long id) {
		return sessionFactory.getCurrentSession().get(OperationBancaire.class, id);
	}

	@Override
	public List<OperationBancaire> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<OperationBancaire> cq = cb.createQuery(OperationBancaire.class);
		Root<OperationBancaire> root = cq.from(OperationBancaire.class);
		cq.select(root);
		Query<OperationBancaire> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, OperationBancaire opperation) {
		Session session = sessionFactory.getCurrentSession();
		OperationBancaire opp = session.byId(OperationBancaire.class).load(id);
		opp.setMontant(opperation.getMontant());
		opp.setDateVirement(opp.getDateVirement());
		opp.setCompte(opperation.getCompte());
		session.flush();

	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		OperationBancaire opperation = session.byId(OperationBancaire.class).load(id);
		session.delete(opperation);

	}

}
