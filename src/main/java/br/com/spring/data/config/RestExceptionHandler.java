package br.com.spring.data.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		
		Map<String, String> resp = new HashMap<>();
		
		resp.put("errorMessage", String.format("Objeto %s n\u00E3o encontrado!", ex.getMessage()));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}
	
	@ExceptionHandler(value = { IllegalArgumentException.class })
	protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex,
			WebRequest request) {
		
		Map<String, String> resp = new HashMap<>();
		
		resp.put("errorMessage", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}
}
