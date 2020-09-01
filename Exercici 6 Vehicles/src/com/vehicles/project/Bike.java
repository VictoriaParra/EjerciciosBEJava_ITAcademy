package com.vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	/*
	 * FASE 3 - Modifica el proyecto anterior a�adiendo los m�todos necesarios a
	 * Bike, de manera que se pueda a�adir ruedas delanteras y traseras.
	 */

	public void addBikeWheels(Wheel frontWheel, Wheel backWheel) {
		addWheel(frontWheel);
		addWheel(backWheel);
	}

	public void addWheel(Wheel wheel) {

		this.wheels.add(wheel);

	}

}