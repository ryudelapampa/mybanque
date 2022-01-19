package fr.banque.mybanque.controllerrest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/")
public class ControllerWeb {
	
	public ControllerWeb() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("titre", "Home");
		return "/home";
	}
	
	@GetMapping("/")
	public String home2(Model model) {
		model.addAttribute("titre", "Home");
		return "/home";
	}

}
