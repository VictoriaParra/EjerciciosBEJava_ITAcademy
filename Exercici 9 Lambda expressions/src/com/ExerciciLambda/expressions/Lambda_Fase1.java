package com.ExerciciLambda.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda_Fase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Ejercicio 1

		/*
		 * Teniendo una lista de cadenas de nombres propios, escribe un método que
		 * devuelva una lista de todas las cadenas que comienzan con la letra 'a'
		 * (mayuscula) y tienen exactamente 3 letras. Imprime el resultado.
		 */

		List<String> names = new ArrayList<String>();
		names.add("Aimar");
		names.add("Ana");
		names.add("Juan");
		names.add("Ara");
		names.add("Carolina");
		names.add("Noa");

		List<String> namesWithA = names.stream().filter(name -> name.length() == 3 && name.startsWith("A"))
				.collect(Collectors.toList()); // = .forEach(name -> namesWithA.add(name));

		System.out.println("Resultado ejercicio 1:");
		
		System.out.println(namesWithA);

		// --------------------------------------------------------------------------------------
		// Ejercicio 2

		/*
		 * Escribe un método que devuelva una cadena separada por comas basada en una
		 * lista de integers. Cada elemento debería ir precedido por la letra "e" si el
		 * número es par, y precedido de la letra "o" si el número es impar. Por
		 * ejemplo, si la lista de entrada es (3,44), la salida debería ser "o3, E44".
		 * Imprime el resultado.
		 */

		List<Integer> numbers = Arrays.asList(1, 22, 55, 63, 66);

		System.out.println("Resultado ejercicio 2:");
		
		System.out.println(Lambda_Fase1.getNewString(numbers));

		// --------------------------------------------------------------------------------------
		// Ejercicio 3

		/*
		 * Teniendo una lista de Strings, escribe un método que devuelva una lista de
		 * todas las cadenas que contengan la letra 'o' e imprime el resultado.
		 */

		List<String> stringList = Arrays.asList("Tomate", "Manzana", "Aceite", "Queso");

		// stream + lambda
		List<String> newStringList = stringList.stream().filter(s -> s.contains("o")).collect(Collectors.toList());

		System.out.println("Resultado ejercicio 3:");

		System.out.println(newStringList);

		// --------------------------------------------------------------------------------------
		// Ejercicio 4

		/*
		 * Tienes que hacer lo mismo que en el punto anterior, pero devolviendo una
		 * lista que incluya los elementos con más de 5 letras. Imprime el resultado.
		 */
		List<String> shopList = Arrays.asList("Tomate", "Manzana", "Aceite", "Queso", "pan");

		List<String> newShoptList = shopList.stream().filter(product -> product.length() > 5)
				.collect(Collectors.toList());

		System.out.println("Resultado ejercicio 4:");

		System.out.println(newShoptList);

		// --------------------------------------------------------------------------------------
		// Ejercicio 5

		/*
		 * Crea una lista con los número de los meses del año. Imprimir todos los
		 * elementos de la lista con una lambda.
		 */

		List<Integer> monthList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

		System.out.println("Resultado ejercicio 5:");

		monthList.forEach((month) -> {
			System.out.println(month);
		});

		// --------------------------------------------------------------------------------------
		// Ejercicio 6

		/*
		 * Tienes que hacer la misma impresión del punto anterior pero haciéndolo
		 * mediante method reference.
		 */

		System.out.println("Resultado ejercicio 6:");

		monthList.forEach(System.out::println);
	}

	public static String getNewString(List<Integer> numbers) {

		List<String> newListStrings = new ArrayList<String>();

		numbers.forEach(number -> {

			if ((number % 2) == 0) {

				newListStrings.add("E" + number);

			} else {

				newListStrings.add("o" + number);
			}

		});

		return newListStrings.toString();

	}

}
