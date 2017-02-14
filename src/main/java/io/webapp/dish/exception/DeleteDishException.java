package io.webapp.dish.exception;


public class DeleteDishException extends Exception {
	public DeleteDishException(Integer id){
		super("não foi possivel encontrar o prato com id '" + id + "'. ");
	}
}
