package io.webapp.dish.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such dish") //404
public class DishNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public DishNotFoundException(String function, Object attribute){
		System.out.println("error while executing function " + function + " with attribute " + attribute);
	}

}
