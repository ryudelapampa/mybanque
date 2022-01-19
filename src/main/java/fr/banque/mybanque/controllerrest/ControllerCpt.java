package fr.banque.mybanque.controllerrest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.banque.mybanque.exception.CompteNotFoundException;
import fr.banque.mybanque.model.Compte;
import fr.banque.mybanque.repository.iCrudCompte;

@RestController
@CrossOrigin
public abstract class ControllerCpt<T extends Compte> {
	
	@Autowired
	protected iCrudCompte cc;
	
	/*
	 * RECUPERATION TOUT LES COMPTES
	 */
	@GetMapping("all")
	protected abstract Iterable<T> getComptes();

	/*
	 * RECUPERATION COMPTE PAR ID
	 */
	@GetMapping("{id}")
	public abstract T getCompte(@PathVariable("id") Integer pid) throws Exception;

	/*
	 * AJOUT COMPTE
	 */
	@PostMapping
	public abstract T addCompte(@Valid @RequestBody T t, BindingResult result) throws CompteNotFoundException;

	/*
	 * MAJ COMPTE
	 */
	@PutMapping("{id}")
	public abstract T updateCompte(@PathVariable("id") Integer pid,@RequestBody T t) throws CompteNotFoundException;
	
	/*
	 * SUPPRESSION COMPTE
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCompte(@PathVariable("id") Integer pid) throws CompteNotFoundException {
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte non trouvée, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		cc.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Compte supprimé !");	
	}

}
