import java.util.ArrayList;
import java.util.HashMap;

public class Fase3 {

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
		
		// Almacenar en un Map tanto las letras de la lista como el número de veces que aparecen
	
		HashMap<Character, Integer> hmName = new HashMap<Character, Integer>();
		
		int contador; 
		for (int i = 0; i < name.size(); i++) {
			if (hmName.get(name.get(i)) == null) {
				contador=0;
			} else { 
				contador=hmName.get(name.get(i));
		
			}
			contador++;
			hmName.put(name.get(i), contador); //name.get(i)--> KEY y contador-->VALUE
			
		}
		System.out.println(hmName);
			 
	}

}
