package com.dice.game.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // cuando se lanza la excepción, el código de status http sera el 404.
public class ArgumentNotFoundException extends RuntimeException{

	/**
	 * Constructor sin parámetros.
	 */
	public ArgumentNotFoundException() {

	}

	/**
	 * Constructor con parámetro
	 * 
	 * @param message mensaje que va a aparecer al lanzar la excepción.
	 */
	public ArgumentNotFoundException(String message) {

		super(message);
	}

	// Método para suprimir el StackTrace
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

}
