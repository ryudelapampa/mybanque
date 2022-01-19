package fr.banque.mybanque.controllerrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.banque.mybanque.exception.ClientNotFoundException;
import fr.banque.mybanque.exception.CompteNotFoundException;
import fr.banque.mybanque.exception.OperationNotFoundException;

@RestControllerAdvice
public class ControllerGeneralError {

	public ControllerGeneralError() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> onError(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Other Error :" +ex.getMessage());
	}
	
	@ExceptionHandler(value = {ClientNotFoundException.class})
	public ResponseEntity<String> onErrorClient(ClientNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClientError :" +ex.getMessage());
	}
	
	@ExceptionHandler(value = {CompteNotFoundException.class})
	public ResponseEntity<String> onErrorCompte(CompteNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CompteError :" +ex.getMessage());
	}
	
	@ExceptionHandler(value = {OperationNotFoundException.class})
	public ResponseEntity<String> onErrorOperation(OperationNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OperationError :" +ex.getMessage());
	}
	

}
