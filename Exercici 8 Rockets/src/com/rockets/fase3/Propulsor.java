package com.rockets.fase3;

public class Propulsor {

	protected int potenciaMax;

	protected int potenciaActual;

	// Cada propulsor tiene una potencia actual y una m�xima.
	public Propulsor(int potenciaMax) {

		potenciaActual = 0;
		this.potenciaMax = potenciaMax;

	}

}
