package io.webapp.dish.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="dish not found")
public class DeleteDishException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 743116565082007710L;

	public DeleteDishException(Integer id){
		super("não foi possivel encontrar o prato com id '" + id + "'. ");
	}
}
