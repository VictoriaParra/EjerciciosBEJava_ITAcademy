package com.rockets.domain;

/**
 * @author Victoria Parra
 */

public class Propulsor {

	// Atributos del propulsor
	protected int potenciaMax;
	protected int potenciaActual;

	// CONSTRUCTORES

	// Constructor por defecto/vacio
	public Propulsor() {
	}

	/**
	 * Constructor con parametros Cada propulsor tiene una potencia actual y una
	 * máxima.
	 * 
	 * @param potenciaMax potencia maxima del propulsor
	 */
	public Propulsor(int potenciaMax) {

		potenciaActual = 0;
		this.potenciaMax = potenciaMax;

	}

	// GETTERS Y SETTERS

	/**
	 * @return potencia maxima del cohete
	 */
	public int getPotenciaMax() {
		return potenciaMax;
	}

	/**
	 * @param potenciaMax
	 */
	public void setPotenciaMax(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	/**
	 * @return potencia actual del cohete
	 */
	public int getPotenciaActual() {
		return potenciaActual;
	}

	/**
	 * @param potenciaActual del cohete
	 */
	public void setPotenciaActual(int potenciaActual) {
		this.potenciaActual = potenciaActual;
	}

	// Método impresion de datos por consola
	@Override
	public String toString() {
		return String.valueOf(potenciaMax); 
	}

}
