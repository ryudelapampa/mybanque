package fr.banque.mybanque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public class Compte {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="NUMERO")
	private String numero;
	
	@NotNull
	@Column(name="SOLDE")
	private Double solde;
	
	@ManyToMany
	@JoinTable(name="CLIENT_COMPTE",
	joinColumns= @JoinColumn(name="COMPTE_ID", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="CLIENT_ID", referencedColumnName="ID"))
	private Set<Client> clients;
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public Compte(String numero, Double solde, Set<Client> clients) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.clients = clients;
	}
	
	public Compte(String numero, Double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.clients = new HashSet<Client>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
