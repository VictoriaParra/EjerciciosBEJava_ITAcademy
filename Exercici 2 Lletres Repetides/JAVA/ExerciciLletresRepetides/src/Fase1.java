
public class Fase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crear una tabla (char []) con tu nombre donde cada posición corresponda a una letra.

		char[] nombre = new char[8];
		nombre[0] = 'V';
		nombre[1] = 'I';
		nombre[2] = 'C';
		nombre[3] = 'T';
		nombre[4] = 'O';
		nombre[5] = 'R';
		nombre[6] = 'I';
		nombre[7] = 'A';

		// Haz un bucle que recorra esta tabla y muestre por consola cada una de las letras.
		for (int i = 0; i < nombre.length; i++) {
			System.out.println(nombre[i]);
		}
	}

}
