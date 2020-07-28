import java.util.ArrayList;

public class Fase4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Character> name = new ArrayList<Character> ();
		name.add('V');
		name.add('I');
		name.add('C');
		name.add('T');
		name.add('O');
		name.add('R');
		name.add('I');
		name.add('A');
		
		
		// Crear otra lista con tu apellido donde cada posición corresponda a una letra.
		
		ArrayList <Character> surname = new ArrayList<Character> ();
		surname.add('P');
		surname.add('A');
		surname.add('R');
		surname.add('R');
		surname.add('A');
		

		/*
		 * Combinar las dos listas en una sola. Además, añade una posición con un espacio vacío entre 
		 * la primera y la segunda. Es decir, partimos de la lista name y surname y al terminar la ejecución 
		 * sólo tendremos una que se llamará fullname.
		 * Fullname: [ 'N', 'A', 'M', 'E', '', 'S', 'U', 'R', 'N', 'A', 'M', 'E']
		 */

		ArrayList <Character> fullname = new ArrayList<Character> ();
		
		//Opcion 1:	
		fullname.addAll(name);
		fullname.add(' ');
		fullname.addAll(surname);
		
		//Opcion 2:
//		for (int i = 0; i < name.size(); i++) 
//			fullname.add(name.get(i));
//		
//		if (fullname.size()==name.size()) {
//			fullname.add(' ');
//		}
//		
//		for (int i = 0; i < surname.size(); i++) 
//			fullname.add(surname.get(i));
//		
		
		System.out.print("Fullname: "+ fullname);
		
	}

}
