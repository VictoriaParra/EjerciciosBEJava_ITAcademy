package com.rockets.fase3;

public class EjecucionMovimientos implements Runnable {

	protected Cohete cohete;

	protected int posicionPropulsor;

	public EjecucionMovimientos(Cohete cohete, int i) {

		this.cohete = cohete;

		posicionPropulsor = i;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		cohete.acelerarPropulsor(posicionPropulsor);

		// Verificar la velocidad de todos los propulsores. Si todos han alcanzado la
		// velocidad maxima cambiar el estado del cohete a velocidad maxima (isAtMaxSpeed = true)
		cohete.setIsAtMaxSpeed();

		try {
			cohete.waitForMaxSpeed();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		cohete.frenarPropulsor(posicionPropulsor);

	}

}
