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
	 * Constructor con parámetro
	 * 
	 * @param codigo código del cohete
	 * @throws IllegalArgumentException si el nº de caracteres es menor a 8.
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
	 * @return código del cohete
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método para definir el código del cohete
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
	 * Método para establecer los propulsores del cohete
	 * 
	 * @param propulsores lista de propulsores
	 */
	public void setPropulsores(List<Propulsor> propulsores) {
		this.propulsores = propulsores;
	}

	// Método impresion de datos por consola
	@Override
	public String toString() {
		return codigo + ": " + propulsores;
	}

}
