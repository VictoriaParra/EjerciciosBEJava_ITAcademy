import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Con un bucle for deberemos rellenar los dos arrays anteriormente creados.
		 * Añadiremos el nombre del plato y luego el precio. Puedes hacer uso de
		 * diccionarios de datos (Java HasMap)
		 */

		HashMap<String, Integer> hmMenu = new HashMap<String, Integer>();
		hmMenu.put("Hamburguesa doble con queso", 20);
		hmMenu.put("Pizza Margherita", 10);
		hmMenu.put("Ensalada verde", 15);
		hmMenu.put("Patatas fritas", 5);
		hmMenu.put("Huevos estrellados", 10);

		String[] menu = new String[hmMenu.size()];
		Integer[] dishPrice = new Integer[hmMenu.size()];

		int counter = 0;
		for (String i : hmMenu.keySet()) {

			menu[counter] = i;
			dishPrice[counter] = hmMenu.get(i);

			counter++;
		}

		System.out.println("Menu: " + Arrays.toString(menu));
		System.out.println("Precios: " + Arrays.toString(dishPrice));

		/*
		 * Una vez llenos los dos arrays tendremos que mostrarles y preguntar que se
		 * quiere para comer, guardaremos la información en una List usando un bucle
		 * while.
		 * 
		 * Tendremos que preguntar si se quiere seguir pidiendo comida. Puede utilizar
		 * el sistema (1: Si / 0: No), por lo tanto deberá crear otro variable int para
		 * guardar la información.
		 */

		Scanner reader = new Scanner(System.in);

		ArrayList<String> orderList = new ArrayList<String>();

		System.out.println("¿Qué quieres para comer? Introduce un plato del menú");
		orderList.add(reader.nextLine());

		int continuar = 1;

		while (continuar != 0) {

			System.out.println("¿Quiere pedir algo más? Introduzca el número 1: Si / 0: No ");

			try {
				continuar = reader.nextInt();

				switch (continuar) {
				case 1:
					System.out.println("¿Qué más quieres para comer? Introduce un plato");
					reader.nextLine();
					orderList.add(reader.nextLine());
					break;
				case 0:
					System.out.println("Gracias por su pedido!");
					reader.close();
					break;
				default:
					System.out.println("El valor introducido es incorrecto");
					break;

				}
			} catch (Exception ex) {
				System.err.println("ERROR - Ha intruducido una palabra en vez de un digito");
				reader.nextLine();
				//continue;
			}
		}

		System.out.println(
				"Su pedido es: " + orderList.toString() + ". En breves verificaremos su pedido y costo a pagar.");

	}

}
