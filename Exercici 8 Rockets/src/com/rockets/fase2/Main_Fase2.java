package com.rockets.fase2;

import java.util.ArrayList;
import java.util.List;

public class Main_Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creación de dos cohetes
		Cohete cohete1 = null;
		Cohete cohete2 = null;

		try {

			cohete1 = new Cohete("32WESSDS");

			cohete2 = new Cohete("LDSFJA32");

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("Modifique el codigo y vuelva a comenzar");
			System.exit(1);
		}

		// Creación de arrayList para agregar cada propulsor mediante método
		// addaparopulsor
		List<Propulsor> propulsoresList = new ArrayList<Propulsor>();
		Main_Fase2.addPropulsor(propulsoresList, 10);
		Main_Fase2.addPropulsor(propulsoresList, 30);
		Main_Fase2.addPropulsor(propulsoresList, 80);

		// Se agrega el arrayList anterior de propulsores al cohete
		cohete1.addPropulsores(propulsoresList);

		// Se vuelve a inicializar para agregar otros propulsores
		propulsoresList = new ArrayList<Propulsor>();
		Main_Fase2.addPropulsor(propulsoresList, 30);
		Main_Fase2.addPropulsor(propulsoresList, 40);
		Main_Fase2.addPropulsor(propulsoresList, 50);
		Main_Fase2.addPropulsor(propulsoresList, 50);
		Main_Fase2.addPropulsor(propulsoresList, 30);
		Main_Fase2.addPropulsor(propulsoresList, 10);

		cohete2.addPropulsores(propulsoresList);

		// Utilización método print para imprimir el código y cada propulsor con su
		// potencia máxima, de cada cohete.
		cohete1.printCoheteData();
		cohete2.printCoheteData();

	}

	// Método para agregar propulsor, al cual le pasamos una lista vacia y un int;
	// que luego el metodo rellenara.
	static void addPropulsor(List<Propulsor> propulsoresList, int potenciaMax) {

		// Se declara e inicializa un objeto del tipo propulsor al cual le pasamos una
		// potencia máxima
		Propulsor myPropulsor = new Propulsor(potenciaMax);

		// Le agregamos a la lista el objeto anteriormente inicializado
		propulsoresList.add(myPropulsor);

	}

}
