package com.rockets.view;

import java.util.Arrays;

import com.rockets.controller.CoheteController;
import com.rockets.domain.Propulsor;

/**
 * El propgrama crea dos cohetes, le asigna una lista de propulsores y se
 * imprime por consola los datos de cada uno.
 * 
 * Luego por cada uno de los cohetes instanciados se ejecuta de manera
 * simultánea (threads) el método Run de la clase "EjecucionMovimiento". El cual
 * acelera todos los propulsores del cohete hasta llegar a su máxima velocidad y
 * luego los desacelera hasta llegar a la mínima velocidad. Imprimiendo por
 * pantalla los cambios de velocidad en los propulsores.
 * 
 * @author Victoria Parra
 */

public class MainAPP {

	private static CoheteController controller = new CoheteController();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			// Crear cohetes
			controller.createCohete("32WESSDS");
			controller.createCohete("LDSFJA32");

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("Modifique el codigo y vuelva a comenzar");
			System.exit(1);
		}

		/*
		 * Agregar lista de propulsores al cohete. Se le pide por parámetro el código
		 * del cohete (para saber a quien corresponde) y la lista de los propulsores
		 * cada uno con su máxima potencia(constructor).
		 */
		controller.addPropulsores("32WESSDS", Arrays.asList(new Propulsor(10), new Propulsor(30), new Propulsor(80)));

		controller.addPropulsores("LDSFJA32", Arrays.asList(new Propulsor(30), new Propulsor(40), new Propulsor(50),
				new Propulsor(50), new Propulsor(30), new Propulsor(10)));

		// Imprimir por consola los datos de los cohetes
		controller.printCoheteData();

		// Crear un hilo por cohete para que ejecuten simultaneamente el método
		// run declarado en la clase EjecucionMovimiento.
		controller.createThread();

	}

}
