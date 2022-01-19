package fr.banque.mybanque.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "VIREMENT")
public class Virement extends Operation {
	
	@Column(name="BENEFICIAIRE")
	private String beneficiaire;

	public Virement() {
		// TODO Auto-generated constructor stub
	}

	public Virement(String beneficiaire) {
		super();
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
