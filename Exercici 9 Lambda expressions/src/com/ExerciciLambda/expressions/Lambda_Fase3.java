package com.ExerciciLambda.expressions;

public class Lambda_Fase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Crea una Functional Interface que contenga un m�todo abstracto reverse (),
		 * que devuelva un valor String; en otra clase, inyecta en la interfaz creada
		 * mediante una lambda el cuerpo del m�todo, de modo que vuelva la misma cadena
		 * que recibe como par�metro pero al rev�s. Invoca la instancia de la interfaz
		 * pas�ndole una cadena y comprobando el resultado.
		 */

		MyInterface_fase3 reverseString = (string) -> {

			String result = "";

			for (int i = (string.length() - 1); i >= 0; i--)

				result += string.charAt(i);

			return result;
		};

		System.out
				.println("El resultado del texto/palabra al rev�s es: " + reverseString.reverse("Barcelona y madrid"));

	}

}
