package com.rockets.fase1;

public class Cohete {

	/*
	 * Un cohete esta identificado por un código de 8 caracteres y un número de
	 * propulsores.
	 * 
	 * Creamos dos cohetes con los códigos "x" Y "LDSFJA32". El primer cohete tendrá
	 * tres propulsores y el segundo seis propulsores.
	 */

	private String codigo;

	private int cantidadPropulsores;

	public Cohete(String codigo, int cantidadPropulsores) throws IllegalArgumentException {

		if (codigo.length() < 8) {

			throw new IllegalArgumentException(
					"El codigo " + "\"" + codigo + "\"" + " es incorrecto, contiene menos de 8 caracteres");

		}

		this.codigo = codigo;

		this.cantidadPropulsores = cantidadPropulsores;

	}

	public String getCoheteData() {
		return "El codigo es: " + codigo + " y el número de propulsores: " + cantidadPropulsores;
	}

}
