package fr.banque.mybanque.controllerrest;

import java.util.Optional;

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

import fr.banque.mybanque.exception.ClientNotFoundException;
import fr.banque.mybanque.model.Client;
import fr.banque.mybanque.repository.iCrudClient;

@RestController
@CrossOrigin
@RequestMapping("api/client")
public class ControllerClient {
	
	@Autowired
	iCrudClient cc;

	public ControllerClient() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("all")
	public Iterable<Client> getClients(){
		return cc.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Client> getClient(@PathVariable("id") Integer pid) throws Exception {
		if (cc.findById(pid).isEmpty()){
			String s = "Client non trouveé , id: "+pid+" !!";
			throw new ClientNotFoundException(s);
		}
		return cc.findById(pid);
	}
	
	@PostMapping
	public Client addClient(@Valid @RequestBody Client client, BindingResult result) throws ClientNotFoundException {
		if ( result.hasErrors()) {
			String s = result.toString();
			throw new ClientNotFoundException(s);
		}
		return cc.save(client);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") Integer pid) throws ClientNotFoundException {
		if ( cc.findById(pid).isEmpty()) {
			String s = "Client non trouvé, id:"+pid+" !!";
			throw new ClientNotFoundException(s);
		}
		cc.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Client supprimé !");
	}
	
	@PutMapping("{id}")
	public Client updateClient(@PathVariable("id") Integer pid,@RequestBody Client client) throws ClientNotFoundException {
		if (pid != client.getId()) {
			String s = "Error pathvariable entre l'id : "+pid+" et le client JSON "+client+" !!";
			throw new ClientNotFoundException(s);
		}
		if(cc.findById(pid).isEmpty()) {
			String s = "Client non trouvé, id: "+pid+" !!";
			throw new ClientNotFoundException(s);
		}
		return cc.save(client);
	}

}
