package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main_Vehicle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * FASE 2: Mejorar el código anterior comprobando la información necesaria a la
		 * hora de crear los objetos. Hay que tener en cuenta: 1) Una matrícula debe
		 * tener 4 números y dos o tres letras. 2) Un diámetro de la rueda debe ser
		 * superior a 0.4 e inferior a 4.
		 */

		String carPlate = JOptionPane
				.showInputDialog("Introduce la matricula, sin dejar espacios. \n Ejemplo: \"1234ABC\"");
		String carBrand = JOptionPane.showInputDialog("Introduce la marca del coche");
		String carColor = JOptionPane.showInputDialog("Introduce un color");

		int countNumbers = 0;
		int countLetters = 0;
		boolean isPlateOk = false;

		// Comprobar que la matricula tenga 4 númenos y 2 ó 3 letras.
		while (isPlateOk == false) {

			// inicializar contadores.
			countNumbers = 0;
			countLetters = 0;

			// Validar formato matricula.
			for (char c : carPlate.toCharArray()) {

				if (Character.isDigit(c) == true) {
					countNumbers++;
				} else {
					countLetters++;
				}
			}

			if (countLetters < 2 || countLetters > 3 || countNumbers > 4 || countNumbers < 4) {
				JOptionPane.showMessageDialog(null,
						"ERROR - La matricula debe tener un maximo de 4 números y entre 2 y 3 letras");
				carPlate = JOptionPane.showInputDialog("Introduce nuevamente la matricula");

			} else {
				isPlateOk = true; // variable vuelve a true para cortar el loop while.
			}
		}

		Car myCar = new Car(carPlate, carBrand, carColor);

		// 3) Añadirle dos ruedas traseras pidiendo al usuario la marca y el diámetro.
		List<Wheel> myBackWheels = new ArrayList<Wheel>();

		String myBackWheelsBrand = JOptionPane.showInputDialog("Introduce la marca de las ruedas traseras");
		double myBackWheelsDiameter = Double
				.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas traseras"));

		// Comprobar que el diámetro de la rueda es superior a 0.4 e inferior a 4.
		boolean isDiameterOk = false;

		while (isDiameterOk == false) {

			if (myBackWheelsDiameter >= 0.4 && myBackWheelsDiameter <= 4.0) {
				isDiameterOk = true;

			} else {
				JOptionPane.showMessageDialog(null, "El número es incorrecto. El diametro debe ser entre 0.4 y 4");
				myBackWheelsDiameter = Double
						.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas traseras"));
			}
		}

		// Rueda Trasera Izquierda
		myBackWheels.add(new Wheel(myBackWheelsBrand, myBackWheelsDiameter));
		// Rueda Trasera Derecha
		myBackWheels.add(new Wheel(myBackWheelsBrand, myBackWheelsDiameter));

		try {
			myCar.addTwoWheels(myBackWheels);
		} catch (Exception e) {
			System.out.println("El número de ruedas no es igual a 2 o la rueda derecha no es igual a la izquierda");
		}

		// 4) Añadirle dos ruedas delanteras pidiendo al usuario la marca y el diámetro.
		List<Wheel> myFrontWheels = new ArrayList<Wheel>();

		String myFrontWheelsBrand = JOptionPane.showInputDialog("Introduce la marca de las ruedas delanteras");
		double myFrontWheelsDiameter = Double
				.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas delanteras"));

		// Comprobar que el diámetro de la rueda es superior a 0.4 e inferior a 4.
		isDiameterOk = false; // volver a inicializar ya que habia quedado en true en el anterior while.
		while (isDiameterOk == false) {
			if (myFrontWheelsDiameter >= 0.4 && myFrontWheelsDiameter <= 4.0) {
				isDiameterOk = true;
			} else {

				JOptionPane.showMessageDialog(null, "El número es incorrecto. El diametro debe ser entre 0.4 y 4");
				myFrontWheelsDiameter = Double
						.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas delanteras"));
			}
		}

		// Rueda Delantera Izquierda
		myFrontWheels.add(new Wheel(myFrontWheelsBrand, myFrontWheelsDiameter));
		// Rueda Delantera Derecha
		myFrontWheels.add(new Wheel(myFrontWheelsBrand, myFrontWheelsDiameter));

		try {
			myCar.addTwoWheels(myFrontWheels);
		} catch (Exception e) {
			System.out.println("El número de ruedas no es igual a 2 o la rueda derecha no es igual a la izquierda");
		}

	}

}
