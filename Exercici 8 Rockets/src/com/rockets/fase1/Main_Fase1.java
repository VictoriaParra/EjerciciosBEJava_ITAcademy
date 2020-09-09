package com.rockets.fase1;

public class Main_Fase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Crear dos cohetes (código, cantidad propulsores)

		Cohete cohete1 = null;
		Cohete cohete2 = null;

		try {

			cohete1 = new Cohete("x", 3);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}

		try {

			cohete2 = new Cohete("LDSFJA32", 6);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}

		// Mostrar por pantalla el código y el número de propulsores.
		if (cohete1 != null) {
			System.out.println("Cohete1: " + cohete1.getCoheteData());
		}

		if (cohete2 != null) {
			System.out.println("Cohete2: " + cohete2.getCoheteData());
		}

	}

}
