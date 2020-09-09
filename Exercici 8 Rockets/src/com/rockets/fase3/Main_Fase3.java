package com.rockets.fase3;

import java.util.ArrayList;
import java.util.List;

public class Main_Fase3 {

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
		Main_Fase3.addPropulsor(propulsoresList, 10);
		Main_Fase3.addPropulsor(propulsoresList, 30);
		Main_Fase3.addPropulsor(propulsoresList, 80);

		// Se agrega el arrayList anterior de propulsores al cohete
		cohete1.addPropulsores(propulsoresList);

		// Se vuelve a inicializar para agregar otros propulsores
		propulsoresList = new ArrayList<Propulsor>();
		Main_Fase3.addPropulsor(propulsoresList, 30);
		Main_Fase3.addPropulsor(propulsoresList, 40);
		Main_Fase3.addPropulsor(propulsoresList, 50);
		Main_Fase3.addPropulsor(propulsoresList, 50);
		Main_Fase3.addPropulsor(propulsoresList, 30);
		Main_Fase3.addPropulsor(propulsoresList, 10);

		cohete2.addPropulsores(propulsoresList);

		// Utilización método print para imprimir el código y cada propulsor con su
		// potencia máxima, de cada cohete.
		cohete1.printCoheteData();
		cohete2.printCoheteData();

		Thread t = null;
		for (int i = 0; i < cohete1.propulsores.size(); i++) {

			EjecucionMovimientos r = new EjecucionMovimientos(cohete1, i);

			t = new Thread(r);

			t.start();

		}

		// Esperar a que los threads del Cohete 1 finalicen
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread t2 = null;
		for (int i = 0; i < cohete2.propulsores.size(); i++) {

			EjecucionMovimientos r2 = new EjecucionMovimientos(cohete2, i);

			t2 = new Thread(r2);

			t2.start();

		}

		// Una vez que ha terminado el cohete1 comienza el cohete2
		// Esperar a que los threads del Cohete 2 finalicen
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Método para agregar propulsor, al cual le pasamos una lista vacia y dos int;
	// que luego el metodo rellenara.
	static void addPropulsor(List<Propulsor> propulsoresList, int potenciaMax) {

		// Se declara e inicializa un objeto del tipo propulsor al cual le pasamos una
		// potencia actual y una máxima
		Propulsor myPropulsor = new Propulsor(potenciaMax);

		// Le agregamos a la lista el objeto anteriormente inicializado
		propulsoresList.add(myPropulsor);

	}

}
