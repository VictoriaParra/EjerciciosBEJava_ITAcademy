package com.simplehttp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esta clase crea una excepci�n costumizada para que cuando un objeto no se
 * encuentre, lance un mensaje especifico para que el usuario sepa el motivo por
 * el cual no se ha encontrado dicho elemento.
 * 
 * @author Victoria Parra
 */

@ResponseStatus(HttpStatus.NOT_FOUND) // cuando se lanza la excepci�n, el c�digo de status http sera el 404.
public class ArgumentNotFoundException extends RuntimeException {

	/**
	 * Constructor sin par�metros.
	 */
	public ArgumentNotFoundException() {

	}

	/**
	 * Constructor con par�metro
	 * 
	 * @param message mensaje que va a aparecer al lanzar la excepci�n.
	 */
	public ArgumentNotFoundException(String message) {

		super(message);
	}

	// M�todo para suprimir el StackTrace 
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

}
