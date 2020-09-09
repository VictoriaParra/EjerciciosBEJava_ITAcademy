package com.rockets.fase2;

import java.util.ArrayList;
import java.util.List;

public class Cohete {

	private String codigo;

	// private int cantidadPropulsores;

	private List<Propulsor> propulsores = new ArrayList<Propulsor>();

	public Cohete (String codigo) throws IllegalArgumentException {

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

}
