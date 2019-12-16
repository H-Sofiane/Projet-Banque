package com.boraji.tutorial.spring.model;

import java.util.Date;
import javax.persistence.*;



@Entity(name="Op_Bancaire")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeOperation")
public class OperationBancaire {
	
	@Id
	@GeneratedValue
	protected long numero;
	protected double montant;
	protected Date DateVirement;
	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	private Compte compte;
	public OperationBancaire() {
		super();
	}
	public OperationBancaire(long numero, double montant, Date dateVirement) {
		super();
		this.numero = numero;
		this.montant = montant;
		DateVirement = dateVirement;
	}
	public long getNumero() {
		return numero;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateVirement() {
		return DateVirement;
	}
	public void setDateVirement(Date dateVirement) {
		DateVirement = dateVirement;
	}
	
	

}
