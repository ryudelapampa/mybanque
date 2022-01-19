package fr.banque.mybanque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	public CompteCourant() {
		super();
	}
	
}
