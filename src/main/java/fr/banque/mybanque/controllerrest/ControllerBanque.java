package fr.banque.mybanque.controllerrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.banque.mybanque.repository.iCrudBanque;

@RestController
@CrossOrigin
@RequestMapping("api/banque")
public class ControllerBanque {
	
	@Autowired
	iCrudBanque cb;

	public ControllerBanque() {
		// TODO Auto-generated constructor stub
	}

}
