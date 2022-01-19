package fr.banque.mybanque.controllerrest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.banque.mybanque.exception.CompteNotFoundException;
import fr.banque.mybanque.model.AssuranceVie;
import fr.banque.mybanque.repository.iCrudCompte;

@RestController
@CrossOrigin
@RequestMapping("api/AV")
public class ControllerAssuranceVie extends ControllerCpt<AssuranceVie> {

	@Autowired
	iCrudCompte cc;
	
	public ControllerAssuranceVie() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Iterable<AssuranceVie> getComptes() {
		return cc.getAllAssuranceVie();
	}

	@Override
	public AssuranceVie getCompte(@PathVariable("id") Integer pid) throws CompteNotFoundException {
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte non trouvée, id : "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).get() instanceof AssuranceVie != true) {
			String s = "Le compte n'est pas de type Assurance Vie, id : "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		return (AssuranceVie) cc.findById(pid).get();
	}

	@Override
	public AssuranceVie addCompte(@Valid @RequestBody AssuranceVie assurancevie, BindingResult result) throws CompteNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new CompteNotFoundException(s);
		}
		return cc.save(assurancevie);
	}

	@Override
	public AssuranceVie updateCompte(@PathVariable("id") Integer pid,@RequestBody AssuranceVie assurancevie) throws CompteNotFoundException {
		if (pid != assurancevie.getId()) {
			String s = "Error pathvariable entre l'id : "+pid+" et le compte JSON "+assurancevie+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte non trouvée, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).get() instanceof AssuranceVie != true) {
			String s = "Le compte n'est pas de type Assurance Vie, id : "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		return cc.save(assurancevie);
	}


	
}
