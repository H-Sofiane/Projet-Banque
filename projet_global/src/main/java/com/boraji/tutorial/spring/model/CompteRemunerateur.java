package com.boraji.tutorial.spring.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("compteRemnuerateur")
public class CompteRemunerateur extends Compte {
	private float tauxRemuneration;
	private float seuilminimum;
	public float getTauxRemuneration() {
		return tauxRemuneration;
	}
	public void setTauxRemuneration(float tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	public float getSeuilminimum() {
		return seuilminimum;
	}
	public void setSeuilminimum(float seuilminimum) {
		this.seuilminimum = seuilminimum;
	}
}
