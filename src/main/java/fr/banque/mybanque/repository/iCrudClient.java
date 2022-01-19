package fr.banque.mybanque.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.banque.mybanque.model.Client;
import fr.banque.mybanque.model.Compte;

public interface iCrudClient extends CrudRepository<Client, Integer> {

	@Query("select c from Compte c where :client MEMBER OF c.clients")
	public Iterable<Compte> findByClientComptes(Client client);
	
}
