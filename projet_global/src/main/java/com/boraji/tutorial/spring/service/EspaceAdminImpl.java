package com.boraji.tutorial.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.ClientDao;
import com.boraji.tutorial.spring.dao.ConseillerDao;
import com.boraji.tutorial.spring.dao.DemandeCompteDao;
import com.boraji.tutorial.spring.model.Conseiller;
import com.boraji.tutorial.spring.model.DemandeCompte;

@Service("espaceAdmin")
@Transactional(readOnly = true)
public class EspaceAdminImpl implements EspaceAdmin {

	@Autowired
	   private ConseillerDao conseillerDao;
	
	@Autowired
	   private ClientDao clientDao;
	
	@Autowired
	   private DemandeCompteDao demandeCompteDao;

	   @Transactional
	   @Override
	   public long save(Conseiller conseiller) {
	      return conseillerDao.save(conseiller);
	   }

	   @Transactional
	   @Override
	   public Conseiller get(long id) {
	      return conseillerDao.get(id);
	   }

	   @Transactional
	   @Override
	   public List<Conseiller> list() {
	      return conseillerDao.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Conseiller conseiller) {
	      conseillerDao.update(id, conseiller);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
	      conseillerDao.delete(id);
	   }

	@Override
	public long saveDemandeCompte(DemandeCompte demandeCompte) {
		return demandeCompteDao.saveDemandeCompte(demandeCompte);
	}

	@Override
	public DemandeCompte getDemandeCompte(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean affecterDemande(long idConseiller, long idDemandeCompte) {

		Boolean b = false;
		Conseiller conseiller = conseillerDao.get(idConseiller);
		DemandeCompte demandeCompte = demandeCompteDao.get(idDemandeCompte);
		
		demandeCompte.setDateAffectation(new Date());
		demandeCompte.setIsAffected(true);
		demandeCompte.setStatus("NON TRAITEE");
		
		conseiller.getDemandesCompte().add(demandeCompte);
		conseillerDao.update(idConseiller, conseiller);
		
		b =true;
		
		return b;
	}

	@Override
	public Set<DemandeCompte> getAllDemandeCompte() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
