package fr.banque.mybanque.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.banque.mybanque.model.AssuranceVie;
import fr.banque.mybanque.model.Compte;
import fr.banque.mybanque.model.CompteCourant;
import fr.banque.mybanque.model.LivretA;
import fr.banque.mybanque.model.Operation;

public interface iCrudCompte extends CrudRepository<Compte,Integer> {

	@Query("select o from Operation o where o.compte.id = :id")
	public Iterable<Operation> findByCompte(int id);
	
	@Query("select c from CompteCourant c ")
	public Iterable<CompteCourant> getAllCompteCourant();
	
	@Query("select c from AssuranceVie c ")
	public Iterable<AssuranceVie> getAllAssuranceVie();
	
	@Query("select c from LivretA c ")
	public Iterable<LivretA> getAllLivretA();
	
}
