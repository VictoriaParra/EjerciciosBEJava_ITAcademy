
public class Fase4 {

	public static void main(String[] args) {
		/*
		 * Creeu una variable on juntareu el nom i els cognoms (tot en una variable) i
		 * un altre on juntareu la data de naixement separada per �/� (tot en una
		 * variable). Mostreu per consola les variables del nom complet, la data de
		 * naixement i si l�any de naixement es de trasp�s o no.
		 */

		// Creaci�n variable nombre completo.
		String nomComplet = "Victoria Parra";
		System.out.println("El meu nom �s " + nomComplet);

		// Creaci�n variable fecha de nacimiento.
		String dataNaixement = "09/05/1989";
		System.out.println("Vaig n�ixer el " + dataNaixement);

		// Condicional para saber si es o no un a�o bisiesto.
		int a�oNacimiento = 1989;
		if (a�oNacimiento % 4 == 0) {
			System.out.println("El meu any de naixement �s de trasp�s.");
		} else {
			System.out.println("El meu any de naixement no �s de trasp�s.");
		}

	}

}
