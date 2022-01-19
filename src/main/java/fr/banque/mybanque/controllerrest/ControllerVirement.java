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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.banque.mybanque.exception.OperationNotFoundException;
import fr.banque.mybanque.model.Operation;
import fr.banque.mybanque.model.Virement;
import fr.banque.mybanque.repository.iCrudOperation;

@RestController
@CrossOrigin
@RequestMapping("api/virement")
public class ControllerVirement {

	@Autowired
	iCrudOperation oc;
	
	public ControllerVirement() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("all")
	public Iterable<Virement> getVirements(){
		return oc.getAllVirement();
	}

	@GetMapping("{id}")
	public Virement getVirements(@PathVariable("id") Integer pid) throws Exception {
		if (oc.findById(pid).isEmpty()) {
			String s = "Virement non trouveé , id: "+pid+" !!";
			throw new OperationNotFoundException(s);
		}
		return (Virement) oc.findById(pid).get();
	}
	
	@PostMapping
	public Virement addVirement(@Valid @RequestBody Virement virement, BindingResult result) throws OperationNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new OperationNotFoundException(s);
		}
		return oc.save(virement);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVirement(@PathVariable("id") Integer pid) throws OperationNotFoundException {
		if ( oc.findById(pid).isEmpty()) {
			String s = "Virement non trouvé, id:"+pid+" !!";
			throw new OperationNotFoundException(s);
		}
		oc.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Virement supprimé !");
	}
	
	@PutMapping("{id}")
	public Operation updateVirement(@PathVariable("id") Integer pid,@RequestBody Virement virement) throws OperationNotFoundException {
		if (pid != virement.getId()) {
			String s = "Error pathvariable entre l'id : "+pid+" et le virement JSON "+virement+" !!";
			throw new OperationNotFoundException(s);
		}
		if(oc.findById(pid).isEmpty()) {
			String s = "Virement non trouvé, id: "+pid+" !!";
			throw new OperationNotFoundException(s);
		}
		return oc.save(virement);
	}
}
