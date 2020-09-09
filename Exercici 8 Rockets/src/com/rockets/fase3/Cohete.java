package com.rockets.fase3;

import java.util.ArrayList;
import java.util.List;

public class Cohete {

	private String codigo;

	protected boolean isAtMaxSpeed;

	protected List<Propulsor> propulsores = new ArrayList<Propulsor>();

	public Cohete(String codigo) throws IllegalArgumentException {

		if (codigo.length() < 8) {

			throw new IllegalArgumentException(
					"El codigo " + "\"" + codigo + "\"" + " es incorrecto, contiene menos de 8 caracteres");

		}

		this.codigo = codigo;

	}

	// Método para agregar propulsores al cohete.
	public void addPropulsores(List<Propulsor> propulsores) {

		// por cada objeto/elemento que tiene la lista, se agrega a la otra lista.
		for (Propulsor i : propulsores) {

			this.propulsores.add(i);
		}

	}

	// Método para imprimir el código y cada propulsor con su potencia máx
	public void printCoheteData() {

		System.out.print(codigo + ": ");

		int i = 0;
		for (Propulsor p : propulsores) {

			if (i != 0) {
				System.out.print(",");
			}

			System.out.print(p.potenciaMax);
			i++;
		}

		System.out.println(); // Imprimir nueva linea

	}

	public void acelerarPropulsor(int index) {

		int posicion = index;

		for (int i = 0; i <= propulsores.get(posicion).potenciaMax; i++) {

			// aumentar potencia actual
			propulsores.get(posicion).potenciaActual = i;

			System.out.println(codigo + " Propulsor " + posicion + " acelerando potencia "
					+ propulsores.get(posicion).potenciaActual);

			if (i == propulsores.get(posicion).potenciaMax) {

				System.out.println("El propulsor " + posicion + " llego a su máxima potencia -- "
						+ Thread.currentThread().getName());

			}

		}

		System.out.println("Propulsor " + posicion + " potencia actual: " + propulsores.get(posicion).potenciaActual);

	}

	public void setIsAtMaxSpeed() {

		boolean isMaxSpeed = true;

		for (Propulsor p : propulsores) {

			if (p.potenciaMax != p.potenciaActual) {
				isMaxSpeed = false;
				break;
			}
		}

		// Si el cohete alcanza la potencia máx imprimir mensaje
		if (isAtMaxSpeed == false && isMaxSpeed == true) {
			System.out.println("El cohete " + codigo + " ha alcanzado la potencia total máxima");
		}

		// Actualizar isAtMaxSpeed del Objeto
		isAtMaxSpeed = isMaxSpeed;

	}

	public synchronized void waitForMaxSpeed() throws InterruptedException {
		// Pausar el método run de este propulsor(thread) hasta que todos lleguen a
		// la potencia maxima.
		while (isAtMaxSpeed == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		notifyAll();

	}

	public void frenarPropulsor(int index) {

		int posicion = index;

		for (int i = propulsores.get(posicion).potenciaActual; i >= 0; i--) {

			// reducir potencia actual
			propulsores.get(posicion).potenciaActual = i;

			System.out.println(codigo + " Propulsor " + posicion + " frenando potencia "
					+ propulsores.get(posicion).potenciaActual);

			if (i == 0) {

				System.out.println("El propulsor " + posicion + " del cohete " + codigo + " esta frenado -- "
						+ Thread.currentThread().getName());

			}
		}

	}

}
