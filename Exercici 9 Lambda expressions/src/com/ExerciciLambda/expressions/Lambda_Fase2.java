package com.ExerciciLambda.expressions;

public class Lambda_Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Crea una Functional Interface que contenga un método abstracto getPiValue (),
		 * que devuelve un valor double; en otra clase, instancie la interfaz y
		 * asignarle mediante una lambda el valor 3.1415. Invoca el método getPiValue de
		 * la instancia de interfaz e imprime el resultado.
		 */

		MyInterface_fase2 piValue = () -> {

			//Bloque de código
			double PI = 3.1415;

			return PI;

		};

		System.out.println("El valor de PI es: " + piValue.getPiValue());

		// otra posibilidad en una linea
		MyInterface_fase2 piValue2 = () -> 3.1415;

		System.out.println("El valor de PI es: " + piValue2.getPiValue());

	}

}
