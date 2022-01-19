package fr.banque.mybanque.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("ASSURANCEVIE")
public class AssuranceVie extends Compte{

	@NotNull
	@Column(name="DATE_FIN")
	private Date dateFin;
	
	@NotNull
	@Column(name="TAUX")
	private Double taux;
	
	public AssuranceVie() {
		// TODO Auto-generated constructor stub
	}

	public AssuranceVie(Date dateFin, Double taux) {
		super();
		this.dateFin = dateFin;
		this.taux = taux;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	

}
