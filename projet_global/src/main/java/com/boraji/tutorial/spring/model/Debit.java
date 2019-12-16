package com.boraji.tutorial.spring.model;

import java.io.Serializable;

import javax.persistence.*;
// c'est moi!!!!!!!!!!!!!
@Entity
@DiscriminatorValue("D")
public class Debit extends OperationBancaire implements Serializable {
	
	public Debit(){
		super();
	}
	

}
