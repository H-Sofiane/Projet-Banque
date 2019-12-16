package com.boraji.tutorial.spring.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Credit extends OperationBancaire {

	
	public Credit() {
		super();
	}
	

}
