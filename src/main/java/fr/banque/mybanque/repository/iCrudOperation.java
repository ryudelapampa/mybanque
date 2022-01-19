package fr.banque.mybanque.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.banque.mybanque.model.Operation;
import fr.banque.mybanque.model.Virement;

public interface iCrudOperation extends CrudRepository<Operation, Integer> {

	@Query("select o from Virement o ")
	public Iterable<Virement> getAllVirement();
	
}
