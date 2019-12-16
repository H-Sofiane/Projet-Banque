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

import com.boraji.tutorial.spring.model.Administrateur;

@Repository
public class AdministrateurDaoImpl implements AdministrateurDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Administrateur admin) {
		sessionFactory.getCurrentSession().save(admin);
		return admin.getId();
	}

	@Override
	public Administrateur get(long id) {
		return sessionFactory.getCurrentSession().get(Administrateur.class, id);
	}

	@Override
	public List<Administrateur> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Administrateur> cq = cb.createQuery(Administrateur.class);
		Root<Administrateur> root = cq.from(Administrateur.class);
		cq.select(root);
		Query<Administrateur> query = session.createQuery(cq);
		return query.getResultList();

	}

	@Override
	public void update(long id, Administrateur admin) {
		Session session = sessionFactory.getCurrentSession();
		Administrateur admin2 = session.byId(Administrateur.class).load(id);
		admin2.setMail(admin.getMail());
		admin2.setAdresse(admin.getAdresse());
		admin2.setConseillers(admin.getConseillers());
		admin2.setDemandes(admin.getDemandes());

		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Administrateur admin = session.byId(Administrateur.class).load(id);
		session.delete(admin);
	}

}
