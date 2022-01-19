package fr.banque.mybanque.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.banque.mybanque.model.Banque;
import fr.banque.mybanque.model.Client;

public interface iCrudBanque extends CrudRepository<Banque, Integer> {

	@Query("select c from Client c where c.banque.id = :id")
	public Iterable<Client> findByClient(int id);
	
}
