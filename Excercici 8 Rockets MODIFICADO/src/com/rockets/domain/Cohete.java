package com.rockets.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Victoria Parra
 */

public class Cohete {

	// Atributos del cohete

	private String codigo;

	protected List<Propulsor> propulsores = new ArrayList<Propulsor>();

	// CONSTRUCTORES

	// Constructor por defecto/vacio
	public Cohete() {

	}

	/**
	 * Constructor con par�metro
	 * 
	 * @param codigo c�digo del cohete
	 * @throws IllegalArgumentException si el n� de caracteres es menor a 8.
	 */
	public Cohete(String codigo) throws IllegalArgumentException {

		if (codigo.length() < 8) {
			throw new IllegalArgumentException(
					"El codigo " + "\"" + codigo + "\"" + " es incorrecto, contiene menos de 8 caracteres");
		} else {
			this.codigo = codigo;
		}

	}

	// GETTERS Y SETTERS

	/**
	 * @return c�digo del cohete
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * M�todo para definir el c�digo del cohete
	 * 
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return lista de propulsores
	 */
	public List<Propulsor> getPropulsores() {
		return propulsores;
	}

	/**
	 * M�todo para establecer los propulsores del cohete
	 * 
	 * @param propulsores lista de propulsores
	 */
	public void setPropulsores(List<Propulsor> propulsores) {
		this.propulsores = propulsores;
	}

	// M�todo impresion de datos por consola
	@Override
	public String toString() {
		return codigo + ": " + propulsores;
	}

}
