
public class Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creeu una constant amb el valor de l’any (1948).
		final int ANY = 1948;

		// Creeu una variable que guardi cada quan hi ha un any de traspàs.
		int anyTraspas = 4;

		/*
		 * Calculeu quants anys de traspàs hi ha entre 1948 i el vostre any de naixement
		 * i emmagatzemeu el valor resultant en una variable.
		 */
		int anyNaixement = 1989;
		int resultado = (anyNaixement - ANY) / anyTraspas;

		// Mostreu per pantalla el resultat del càlcul.
		System.out.println(resultado);
	}

}
