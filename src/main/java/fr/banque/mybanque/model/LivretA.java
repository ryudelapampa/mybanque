package fr.banque.mybanque.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("LIVRETA")
public class LivretA extends Compte {

	@NotNull
	@Column(name="TAUX")
	private Double taux;
	
	public LivretA() {
		// TODO Auto-generated constructor stub
	}
	
	public LivretA(Double taux) {
		super();
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}
	
}
