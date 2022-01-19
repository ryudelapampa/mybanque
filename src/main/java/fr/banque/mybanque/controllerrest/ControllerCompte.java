package fr.banque.mybanque.controllerrest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.banque.mybanque.exception.CompteNotFoundException;
import fr.banque.mybanque.model.CompteCourant;
import fr.banque.mybanque.repository.iCrudCompte;

@RestController
@CrossOrigin
@RequestMapping("api/compte")
public class ControllerCompte extends ControllerCpt<CompteCourant> {
	
	@Autowired
	iCrudCompte cc;
	
	public ControllerCompte() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Iterable<CompteCourant> getComptes() {
		return cc.getAllCompteCourant();
	}

	@Override
	public CompteCourant getCompte(@PathVariable("id") Integer pid) throws CompteNotFoundException {
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte non trouvée, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).get() instanceof CompteCourant != true) {
			String s = "Le compte n'est pas de type Compte Courant, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		return (CompteCourant) cc.findById(pid).get();
	}

	@Override
	public CompteCourant addCompte(@Valid @RequestBody CompteCourant compte, BindingResult result) throws CompteNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new CompteNotFoundException(s);
		}
		return cc.save(compte);
	}

	@Override
	public CompteCourant updateCompte(@PathVariable("id")Integer pid,@RequestBody CompteCourant compte) throws CompteNotFoundException {
		if (pid != compte.getId()) {
			String s = "Error pathvariable entre l'id : "+pid+" et le compte JSON "+compte+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte non trouvée, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).get() instanceof CompteCourant != true) {
			String s = "Le compte n'est pas de type Compte Courant, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		return cc.save(compte);
	}
	
	

}
