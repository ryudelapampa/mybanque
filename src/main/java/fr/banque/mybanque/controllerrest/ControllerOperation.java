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
import fr.banque.mybanque.repository.iCrudOperation;

@RestController
@CrossOrigin
@RequestMapping("api/operation")
public class ControllerOperation {

	@Autowired
	iCrudOperation oc;
	
	public ControllerOperation() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("all")
	public Iterable<Operation> getOperations(){
		return oc.findAll();
	}
	
	@GetMapping("{id}")
	public Operation getOperations(@PathVariable("id") Integer pid) throws OperationNotFoundException {
		if (oc.findById(pid).isEmpty()) {
			String s = "Opération non trouveé , id: "+pid+" !!";
			throw new OperationNotFoundException(s);
		}
		return oc.findById(pid).get();
	}
	
	@PostMapping
	public Operation addOperation(@Valid @RequestBody Operation operation, BindingResult result) throws OperationNotFoundException {
		if (result.hasErrors()) {
			String s = result.toString();
			throw new OperationNotFoundException(s);
		}
		return oc.save(operation);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteOperation(@PathVariable("id") Integer pid) throws OperationNotFoundException {
		if ( oc.findById(pid).isEmpty()) {
			String s = "Operation non trouvé, id:"+pid+" !!";
			throw new OperationNotFoundException(s);
		}
		oc.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Operation supprimé !");
	}
	
	@PutMapping("{id}")
	public Operation updateOperation(@PathVariable("id") Integer pid,@RequestBody Operation operation) throws OperationNotFoundException {
		if (pid != operation.getId()) {
			String s = "Error pathvariable entre l'id : "+pid+" et l'operation JSON "+operation+" !!";
			throw new OperationNotFoundException(s);
		}
		if(oc.findById(pid).isEmpty()) {
			String s = "Operation non trouvé, id: "+pid+" !!";
			throw new OperationNotFoundException(s);
		}
		return oc.save(operation);
	}

}
