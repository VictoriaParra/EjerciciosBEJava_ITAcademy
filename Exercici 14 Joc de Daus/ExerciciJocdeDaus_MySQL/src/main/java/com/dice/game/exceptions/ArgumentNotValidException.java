package com.dice.game.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esta clase crea una excepción personalizada para que cuando en el
 * request/body se pase un argumento no valido, lance un mensaje específico y
 * así el usuario sepa el motivo por el cual no es valido.
 * 
 * @author Victoria Parra
 */

@ResponseStatus(HttpStatus.BAD_REQUEST) // cuando se lanza la excepción, el código de status http sera el 400.
public class ArgumentNotValidException extends RuntimeException {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor sin parámetros.
	 */
	public ArgumentNotValidException() {

	}

	/**
	 * Constructor con parámetro
	 * 
	 * @param message mensaje que va a aparecer al lanzar la excepción.
	 */
	public ArgumentNotValidException(String message) {

		super(message);
	}

	// Método para suprimir el StackTrace
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}
