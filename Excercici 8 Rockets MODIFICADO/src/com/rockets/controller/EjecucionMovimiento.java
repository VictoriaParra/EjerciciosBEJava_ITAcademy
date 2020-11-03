package com.rockets.controller;

import com.rockets.domain.Cohete;

/**
 * Esta clase implementa la interface Runnable. Se establece el método run que
 * luego el thread/hilo ejecutará. (se establece el accionar del hilo)
 * 
 * @author Victoria Parra
 */

public class EjecucionMovimiento implements Runnable {

	// Atributos de la clase EjecucionMovimiento

	protected Cohete cohete;
	private static CoheteController controller = new CoheteController();

	// Constructores

	public EjecucionMovimiento() {

	}

	/**
	 * Constructor con parámetro
	 * 
	 * @param cohete
	 */
	public EjecucionMovimiento(Cohete cohete) {
		this.cohete = cohete;
	}

	/*
	 * Método run. Se establece que el cohete acelera y luego frena. Dichos metodos
	 * son de la clase controladora a los cuales hay que pasar por parametro un
	 * objeto de tipo Cohete.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		controller.acelerarCohete(cohete);

		controller.frenarCohete(cohete);

	}

}
