package io.webapp.dish.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {
	
	@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="search parameter not acceptable")
	@ExceptionHandler(NoSuchMethodException.class)
	public void conflict(){
		System.out.println("no such method");
	}

	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED, reason="bad post request")
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public void badPost(){
		System.out.println("can't read inputed information");
	}
	
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED, reason="class does not exist")
	@ExceptionHandler(ClassNotFoundException.class)
	public void badClassName(){
		System.out.println("user input class name that does not exist in classpath");
	}
	
}
