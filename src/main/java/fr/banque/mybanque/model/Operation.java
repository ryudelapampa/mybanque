package fr.banque.mybanque.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="NATURE")
@DiscriminatorValue(value = "OPERATION")
public class Operation {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="MONTANT")
	private Double montant;
	
	@Column(name="MOTIF")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="COMPTE_ID")
	private Compte compte;

	public Operation() {
		// TODO Auto-generated constructor stub
	}
	
	public Operation(Date date, Double montant, String motif) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = null;
	}

	public Operation(Date date, Double montant, String motif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	

}
