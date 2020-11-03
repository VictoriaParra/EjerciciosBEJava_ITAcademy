package com.rockets.controller;

import java.util.List;

import com.rockets.domain.Cohete;
import com.rockets.domain.Propulsor;
import com.rockets.persistence.CoheteRepository;

/**
 * Clase controladora: crea cohetes y tiene métodos para gestionarlos.
 * 
 * @author Victoria Parra
 */

public class CoheteController {

	// Atributos de la clase
	private CoheteRepository repo = new CoheteRepository();

	// Constructor por defecto/vacio
	public CoheteController() {

	}

	/**
	 * Método para crear cohete y añadirlo a la lista de cohetes
	 * 
	 * @param codigo
	 * @throws IllegalArgumentException
	 */
	public void createCohete(String codigo) throws IllegalArgumentException {

		Cohete newCohete = new Cohete(codigo);
		repo.addCohete(newCohete);
	}

	// Método para agregar propulsores al cohete.
	public void addPropulsores(String codigo, List<Propulsor> propulsores) {

		// Se verifica si el codigo esta en la lista de cohetes y se le agrega la
		// lista de propulsores
		repo.getCohetes().forEach(cohete -> {

			if (cohete.getCodigo().equalsIgnoreCase(codigo)) {
				cohete.setPropulsores(propulsores);
			}
		});

	}

	// Método para imprimir el código y cada propulsor
	public void printCoheteData() {

		// Por cada cohete de la lista se hace un System.out.println de su contenido
		repo.getCohetes().forEach(System.out::println);

	}

	// Método que crea un thread/hilo por cada cohete de la lista de cohetes
	public void createThread() {

		for (int i = 0; i < repo.getCohetes().size(); i++) {

			EjecucionMovimiento run = new EjecucionMovimiento(repo.getCohetes().get(i));

			// Se instancia el thread
			Thread hiloCohete = new Thread(run);

			// Se ejecuta
			hiloCohete.start();

		}

	}

	/**
	 * Método para acelerar cohete. La potencia actual de cada propulsor va a
	 * incrementarse hasta llegar a ser igual que su potencia máxima.
	 * 
	 * @param cohete
	 */
	public void acelerarCohete(Cohete cohete) {

		// Instanciar nuevo cohete que va a ser igual al cohete del parámetro
		Cohete newCohete = cohete;

		// Se loopea cada propulsor donde su potencia actual va a ir aumentando hasta
		// llegar a ser igual que la potencia máxima.
		newCohete.getPropulsores().forEach((propulsor) -> {

			for (int i = 0; i <= propulsor.getPotenciaMax(); i++) {

				propulsor.setPotenciaActual(i);

				System.out.println("Propulsor index " + cohete.getPropulsores().indexOf(propulsor) + " del cohete: "
						+ cohete.getCodigo() + " acelerando, potencia actual: " + i);
			}

		});

		System.out.println("El cohete " + newCohete.getCodigo() + " ha llegado a su potencia maxima");

	}

	/**
	 * Método para que los cohetes frenen. Sus propulsores lleguen a una potencia
	 * actual de 0.
	 * 
	 * @param cohete
	 */
	public void frenarCohete(Cohete cohete) {

		Cohete newCohete = cohete;

		// Se loopea cada propulsor donde su potencia actual va a ir disminuyendo hasta
		// llegar a ser 0.
		newCohete.getPropulsores().forEach(propulsor -> {

			for (int i = propulsor.getPotenciaActual(); i >= 0; i--) {

				propulsor.setPotenciaActual(i);

				System.out.println("Propulsor index " + cohete.getPropulsores().indexOf(propulsor) + " del cohete: "
						+ cohete.getCodigo() + " frenando, potencia actual: " + i);
			}

		});

		System.out.println("El cohete " + newCohete.getCodigo() + " ha frenado.");

	}

}
