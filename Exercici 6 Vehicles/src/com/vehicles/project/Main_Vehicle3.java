package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main_Vehicle3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Modificar el Main anterior, añadiendo la opción de Bike o Car: 0) Preguntar
		 * al usuario si desea crear un coche o una moto. 1) Pedir al usuario la
		 * matrícula, la marca y su color. 2) Crear el vehículo con los datos
		 * anteriores. 3) Añadirle las ruedas traseras correspondientes, pidiendo al
		 * usuario la marca y el diámetro. 4) Añadirle las ruedas delanteras
		 * correspondientes, pidiendo al usuario la marca y el diámetro.
		 */

		String chosenVehicle = JOptionPane.showInputDialog("Introduce que vehiculo deseas crear: Moto o Coche");

		boolean isSelectionOk = false;

		while (isSelectionOk == false) {

			switch (chosenVehicle.toLowerCase()) {
			case "moto":
				Main_Vehicle3.createBike();
				isSelectionOk = true;
				break;

			case "coche":
				Main_Vehicle3.createCar();
				isSelectionOk = true;
				break;

			default:
				JOptionPane.showMessageDialog(null, "ERROR - Ha introducido mal el vehiculo.");
				chosenVehicle = JOptionPane
						.showInputDialog(" Vuelva a introducir que vehiculo deseas crear: Moto ó Coche");
			}
		}

	}

	static void createBike() {

		int countNumbersBike = 0;
		int countLettersBike = 0;

		boolean isPlateBikeOk = false;

		String bikePlate = JOptionPane
				.showInputDialog("Introduce la matricula, sin dejar espacios. \n Ejemplo: \"1234ABC\"");
		String bikeBrand = JOptionPane.showInputDialog("Introduce la marca de la moto");
		String bikeColor = JOptionPane.showInputDialog("Introduce un color");

		while (isPlateBikeOk == false) {

			// inicializar contadores.
			countNumbersBike = 0;
			countLettersBike = 0;

			// Validar formato matricula.
			for (char c : bikePlate.toCharArray()) {

				if (Character.isDigit(c) == true) {
					countNumbersBike++;
				} else {
					countLettersBike++;
				}
			}

			if (countLettersBike < 2 || countLettersBike > 3 || countNumbersBike > 4 || countNumbersBike < 4) {
				JOptionPane.showMessageDialog(null,
						"ERROR - La matricula debe tener un maximo de 4 números y entre 2 y 3 letras");
				bikePlate = JOptionPane.showInputDialog("Introduce nuevamente la matricula");

			} else {
				isPlateBikeOk = true; // variable vuelve a true para cortar el loop while.
			}
		}

		Bike myBike = new Bike(bikePlate, bikeBrand, bikeColor);

		Wheel myBackWheel;

		String myBackWheelBrand = JOptionPane.showInputDialog("Introduce la marca de las ruedas traseras");
		double myBackWheelDiameter = Double
				.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas traseras"));

		// Comprobar que el diámetro de la rueda es superior a 0.4 e inferior a 4.
		boolean isDiameterOk = false;

		while (isDiameterOk == false) {

			if (myBackWheelDiameter >= 0.4 && myBackWheelDiameter <= 4.0) {
				isDiameterOk = true;

			} else {
				JOptionPane.showMessageDialog(null, "El número es incorrecto. El diametro debe ser entre 0.4 y 4");
				myBackWheelDiameter = Double
						.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas traseras"));
			}
		}

		// Rueda Trasera
		myBackWheel = new Wheel(myBackWheelBrand, myBackWheelDiameter);

		// 4) Añadirle dos ruedas delanteras pidiendo al usuario la marca y el diámetro.
		Wheel myFrontWheel;

		String myFrontWheelBrand = JOptionPane.showInputDialog("Introduce la marca de las ruedas delanteras");
		double myFrontWheelDiameter = Double
				.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas delanteras"));

		// Comprobar que el diámetro de la rueda es superior a 0.4 e inferior a 4.
		isDiameterOk = false; // volver a inicializar ya que habia quedado en true en el anterior while.
		while (isDiameterOk == false) {
			if (myFrontWheelDiameter >= 0.4 && myFrontWheelDiameter <= 4.0) {
				isDiameterOk = true;
			} else {

				JOptionPane.showMessageDialog(null, "El número es incorrecto. El diametro debe ser entre 0.4 y 4");
				myFrontWheelDiameter = Double
						.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas delanteras"));
			}
		}

		// Rueda Delantera
		myFrontWheel = new Wheel(myFrontWheelBrand, myFrontWheelDiameter);

		myBike.addBikeWheels(myFrontWheel, myBackWheel);

		System.out.println(
				"Su matricula es: " + myBike.plate + ", marca: " + myBike.brand + " y el color: " + myBike.color);
		System.out.println(
				"La rueda trasera es marca: " + myBackWheelBrand + " y su diametro es: " + myBackWheelDiameter);
		System.out.println(
				"La rueda delantera es marca: " + myFrontWheelBrand + " y su diametro es: " + myFrontWheelDiameter);

	}

	static void createCar() {

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

		System.out
				.println("Su matricula es: " + myCar.plate + ", marca: " + myCar.brand + " y el color: " + myCar.color);
		System.out.println(
				"Las ruedas traseras son marca: " + myBackWheelsBrand + " y su diametro es: " + myBackWheelsDiameter);
		System.out.println("Las ruedas delanteras son marca: " + myFrontWheelsBrand + " y su diametro es: "
				+ myFrontWheelsDiameter);

	}

}
