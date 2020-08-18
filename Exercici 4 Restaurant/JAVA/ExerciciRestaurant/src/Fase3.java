import java.util.ArrayList;

public class Fase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Una vez hemos acabado de pedir la comida, tendremos que comparar la lista con
		 * el array que hemos hecho al principio. En caso de que la información que
		 * hemos introducido en la List coincida con la del array, tendremos que sumar
		 * el precio del producto solicitado; en el caso contrario tendremos que mostrar
		 * un mensaje que diga que el producto que hemos pedido no existe.
		 */

		String[] menu = { "Hamburguesa doble con queso", "Ensalada verde", "Pizza Margherita", "Huevos estrellados",
				"Patatas fritas" };

		Integer[] dishPrice = { 20, 15, 10, 10, 5 };

		ArrayList<String> orderList = new ArrayList<String>();
		orderList.add("Hamburguesa doble con queso");
		orderList.add("patatas fritas");
		orderList.add("Hamburguesa doble con queso");
		orderList.add("ensalada");
		orderList.add("huevos estrellados");
		orderList.add("Hamburguesa doble");
		orderList.add("Pizza Margherita");
		orderList.add("Pizza Margherita");
		orderList.add("Pizza");

		int totalPrice = 0;
		boolean isProductFound = false;

		for (int i = 0; i < orderList.size(); i++) {

			isProductFound = false;

			for (int j = 0; j < menu.length; j++) {

				if (orderList.get(i).toLowerCase().contains(menu[j].toLowerCase())) {
					totalPrice = (totalPrice + dishPrice[j]);
					isProductFound = true;
				}
			}

			if (isProductFound == false) {
				System.out.println("Este producto no existe: " + orderList.get(i));
			}
		}

		System.out.println("El precio a pagar es " + totalPrice + " € ");

	}

}
