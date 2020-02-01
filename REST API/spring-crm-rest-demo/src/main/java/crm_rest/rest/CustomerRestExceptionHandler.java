package crm_rest.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		CustomerErrorResponse o = new CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(), exc.getMessage(), LocalDateTime.now().toString());

		return new ResponseEntity<>(o, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
		
		CustomerErrorResponse o = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(), exc.getMessage(), LocalDateTime.now().toString());

		return new ResponseEntity<>(o, HttpStatus.BAD_REQUEST);
	}
}
