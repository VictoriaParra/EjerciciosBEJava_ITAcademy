package com.videos.exercici;

import java.lang.Exception;

public class EmptyFieldException extends Exception {

	public EmptyFieldException() {
	}

	public EmptyFieldException(String msj_error) {

		super(msj_error);
	}

	// Quería probar hacer una excepción propia. Aunque creo que hubiera sido lo mismo
	// si hubiese usado "IllegalArgumentException".

}
