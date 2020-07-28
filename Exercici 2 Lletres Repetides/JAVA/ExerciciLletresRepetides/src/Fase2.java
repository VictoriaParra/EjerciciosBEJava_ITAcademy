import java.util.ArrayList;
import java.util.List;

public class Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//  Cambia la tabla para una lista (List <Character>)
		char [] nombre1 = {'V','I', 'C', 'T','O','R','I','A','4'}; //Le agregue un numero para verificar el ultimo paso
	
		
		List <Character> nombre = new ArrayList<Character> ();
	
//		Utilizacion de FOR para agregar el contenido del array nombre1 al arrayList nombre.
		for (int i = 0; i < nombre1.length; i++) {
			nombre.add(nombre1[i]); 	
		}
	
		
		//En el bucle, si la letra es una vocal imprime en la consola: 'VOCAL'. Sino, imprime: 'CONSONTANT'.
		//Si encuentras un numero, muestra por pantalla: 'Los nombres de personas no contienen números!'.
		
		//Utilizacion del For para recorrer el arrayList.
		for (int i = 0; i < nombre.size(); i++) {
			System.out.print(nombre.get(i) + ": ");
	
		// Utilizacion de switch para saber si es 'vocal' o 'consonant'.	
		switch ( Character.toLowerCase(nombre.get(i)) ){
		case 'a':
			System.out.println("VOCAL");
			break;
		case 'e':
			System.out.println("VOCAL");
			break;
		case 'i':
			System.out.println("VOCAL");
			break;
		case 'o':
			System.out.println("VOCAL");
			break;
		case 'u':
			System.out.println("VOCAL");
			break;
		default:
			// Utilizacion del condicional IF para verificar si hay numeros o no.
			if (Character.isDigit(nombre.get(i))==true) {
				System.out.println("Los nombres de personas no contienen números!");
			} else {
				System.out.println("CONSONANT");
			}

		}
	
		}
	}

}
