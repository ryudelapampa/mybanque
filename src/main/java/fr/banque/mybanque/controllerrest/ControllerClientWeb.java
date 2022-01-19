package fr.banque.mybanque.controllerrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.banque.mybanque.model.Banque;
import fr.banque.mybanque.model.Client;
import fr.banque.mybanque.repository.iCrudBanque;
import fr.banque.mybanque.repository.iCrudClient;

@Controller
@CrossOrigin
@RequestMapping("/client")
public class ControllerClientWeb {

	@Autowired
	iCrudClient cc;
	
	@Autowired
	iCrudBanque cb;
	
	public ControllerClientWeb() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/clients")
	public String findAll(Model model) {
		model.addAttribute("clients", (List<Client>) cc.findAll());
		model.addAttribute("titre", "Liste des clients");
		return "clients/Liste";
	}
	
	@GetMapping("/ajout")
	public String addClient(Model model) {
		model.addAttribute("banques", (List<Banque>) cb.findAll());
		model.addAttribute("client", new Client());
		return "clients/add";   
	}
	
	@PostMapping("/ajout")
	public String addClient(@ModelAttribute Client client, Model model) {
		cc.save(client);
		return "redirect:/client/clients";     
	} 
	
	@GetMapping("/delete/{id}")
	public String deleteClient(@ModelAttribute Client client, Model model) {
		cc.delete(client);
		return "redirect:/client/clients";
	}
	
}
