
public class Fase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Crea tres variables string e inicialitzales amb les dades pertinents (nom, cognom1, cognom2).
		String nom = "Victoria";
		String cognom1 = "Parra";
		String cognom2 = "Cavagna";

		// Crea tres variables int e inicialitzales amb les dades pertinents (dia, mes, any).
		int dia = 20;
		int mes = 7;
		int any = 2020;

		// Mostra per pantalla les variables string concatenant-les en aquest ordre (cognom1 + cognom2, + nom).
		System.out.println("Nombre: " + cognom1 + " " + cognom2 + ", " + nom);

		// Mostra per pantalla les variables int concatenant-les amb “/” entre cada una d’elles.
		System.out.println("Fecha: " + dia + "/" + mes + "/" + any);
	}

}
