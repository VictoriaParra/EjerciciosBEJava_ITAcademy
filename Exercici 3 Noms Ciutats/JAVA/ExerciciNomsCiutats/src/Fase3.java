import java.util.Arrays;

public class Fase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Cambiar las vocales "a" de los nombres de las ciudades por el numero 4 y guarde los nombres 
		//modificados en un nuevo array (ArrayCiutatsModificades).
		
		String [] arrayCities= {"Barcelona", "Madrid", "Valencia", "Malaga", "Cadiz", "Santander"};
		
		//Declaración nuevo array para las ciudades modificadas.
		String [] arrayCitiesMod = new String [arrayCities.length];
		
		
		for (int i = 0; i < arrayCities.length; i++) {
			// Modificación de 'a' por '4' mediante método replace().
			// Assignación de nombre modificados al nuevo array
			arrayCitiesMod[i]=arrayCities[i].replace('a', '4'); 
		}
		
		// Muestre por consola el array modificado y ordenado por orden alfabético.
		Arrays.sort(arrayCitiesMod);
		System.out.println(Arrays.toString(arrayCitiesMod));

	}

}
