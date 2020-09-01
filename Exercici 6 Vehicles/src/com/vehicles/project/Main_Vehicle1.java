package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main_Vehicle1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Fase1
		// 1) Pedir al usuario la matrícula del coche, la marca y su color.

		String carPlate = JOptionPane.showInputDialog("Introduce la matricula");
		String carBrand = JOptionPane.showInputDialog("Introduce la marca del coche");
		String carColor = JOptionPane.showInputDialog("Introduce un color");

		// 2) Crear el coche con los datos anteriores.
		Car myCar = new Car(carPlate, carBrand, carColor);

		// 3) Añadirle dos ruedas traseras pidiendo al usuario la marca y el diámetro.

		List<Wheel> myBackWheels = new ArrayList<Wheel>();

		String myBackWheelsBrand = JOptionPane.showInputDialog("Introduce la marca de las ruedas traseras");
		double myBackWheelsDiameter = Double
				.parseDouble(JOptionPane.showInputDialog("Introduce el diametro de las ruedas traseras"));

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
