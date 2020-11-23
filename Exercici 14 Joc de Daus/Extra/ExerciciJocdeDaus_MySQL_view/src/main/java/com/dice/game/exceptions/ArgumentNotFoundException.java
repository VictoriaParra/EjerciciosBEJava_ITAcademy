package com.dice.game.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esta clase crea una excepción costumizada para que cuando un objeto no se
 * encuentre, lance un mensaje especifico para que el usuario sepa el motivo por
 * el cual no se ha encontrado dicho elemento.
 * 
 * @author Victoria Parra
 */

@ResponseStatus(HttpStatus.NOT_FOUND) // cuando se lanza la excepción, el código de status http sera el 404.
public class ArgumentNotFoundException extends RuntimeException {

	// se debe crear el numero de serie?

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
