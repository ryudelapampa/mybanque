package fr.banque.mybanque.controllerrest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import fr.banque.mybanque.exception.CompteNotFoundException;
import fr.banque.mybanque.model.LivretA;
import fr.banque.mybanque.repository.iCrudCompte;

@RestController
@CrossOrigin
@RequestMapping("api/LA")
public class ControllerLivretA extends ControllerCpt<LivretA>{

	@Autowired 
	iCrudCompte cc;
	
	public ControllerLivretA() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Iterable<LivretA> getComptes(){
		return cc.getAllLivretA();
	}
	
	@Override
	public LivretA getCompte(@PathVariable("id")Integer pid) throws Exception {
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte non trouvée, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).get() instanceof LivretA != true) {
			String s = "Le compte n'est pas de type Livret A, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		return (LivretA) cc.findById(pid).get();
	}

	@Override
	public LivretA addCompte(@Valid @RequestBody LivretA livreta, BindingResult result) throws CompteNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new CompteNotFoundException(s);
		}
		return cc.save(livreta);
	}

	@Override
	public LivretA updateCompte(@PathVariable("id")Integer pid,@RequestBody LivretA livreta) throws CompteNotFoundException {
		if (pid != livreta.getId()) {
			String s = "Error pathvariable entre l'id : "+pid+" et le compte JSON "+livreta+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte non trouvée, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).get() instanceof LivretA != true) {
			String s = "Le compte n'est pas de type Livret A, id: "+pid+" !!";
			throw new CompteNotFoundException(s);
		}
		return cc.save(livreta);
	}

}
