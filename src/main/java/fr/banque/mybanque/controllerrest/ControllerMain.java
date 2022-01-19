//package fr.banque.mybanque.controllerrest;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ControllerMain {
//
//	public ControllerMain() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	@Value("${hello.world}")
//	private String message;
//	
//	@RequestMapping(value = {"/","/index"})
//	@GetMapping
//	public String index(Model model) {
//		model.addAttribute("message", message);
//		return "index";
//	}
//
//}
