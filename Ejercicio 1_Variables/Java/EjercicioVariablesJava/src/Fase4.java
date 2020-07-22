
public class Fase4 {

	public static void main(String[] args) {
		/*
		 * Creeu una variable on juntareu el nom i els cognoms (tot en una variable) i
		 * un altre on juntareu la data de naixement separada per “/” (tot en una
		 * variable). Mostreu per consola les variables del nom complet, la data de
		 * naixement i si l’any de naixement es de traspàs o no.
		 */

		// Creación variable nombre completo.
		String nomComplet = "Victoria Parra";
		System.out.println("El meu nom és " + nomComplet);

		// Creación variable fecha de nacimiento.
		String dataNaixement = "09/05/1989";
		System.out.println("Vaig néixer el " + dataNaixement);

		// Condicional para saber si es o no un año bisiesto.
		int añoNacimiento = 1989;
		if (añoNacimiento % 4 == 0) {
			System.out.println("El meu any de naixement és de traspàs.");
		} else {
			System.out.println("El meu any de naixement no és de traspàs.");
		}

	}

}
