package fr.banque.mybanque.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Adresse {
	
	@NotNull
	@Column(name="NUMERO")
	private Integer numero;
	
	@NotNull
	@Column(name="RUE")
	private String rue;
	
	@NotNull
	@Column(name="CODE_POSTALE")
	private String codePostale;
	
	@NotNull
	@Column(name="VILLE")
	private String ville;

	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public Adresse(Integer numero, String rue, String codePostale, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;  
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
