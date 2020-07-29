
public class Fase4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/*
		 * Consignas:
		 * - Cree un nuevo array para cada una de las ciudades que tenemos. 
		 * El tamaño de los nuevos arrays será la longitud de cada string (string nomCiutat.Length).
		 * - Llene los nuevos arrays letra por letra. 
		 * - Muestre por consola los nuevos arrays con los nombres invertidos (Ej: Barcelona - anolecraB).
		 */
	
		String [] arrayCities= {"Barcelona", "Madrid", "Valencia", "Malaga", "Cadiz", "Santander"};
		
	
		char [] cityName1=arrayCities[0].toCharArray();
		char [] cityName2=arrayCities[1].toCharArray();
		char [] cityName3=arrayCities[2].toCharArray();
		char [] cityName4=arrayCities[3].toCharArray();
		char [] cityName5=arrayCities[4].toCharArray();
		char [] cityName6=arrayCities[5].toCharArray();
		

		//cityName1
		// Utilización de FOR para invertir el orden de cada letra.
		for (int i = cityName1.length - 1; i >= 0 ; i--) {
		 // Si es la última letra hacer println sino print.
		     if (i==0) {
		    	 System.out.println(cityName1[i]);
		     } else {
		    	 System.out.print(cityName1[i]);
		     }     
		}
		
		//cityName2
		for (int i = cityName2.length - 1; i >= 0 ; i--) {
		     if (i==0) {
		    	 System.out.println(cityName2[i]);
		     } else {
		    	 System.out.print(cityName2[i]);
		     }		     
		}
		
		//cityName3
		for (int i = cityName3.length - 1; i >= 0 ; i--) {
		     if (i==0) {
		    	 System.out.println(cityName3[i]);
		     } else {
		    	 System.out.print(cityName3[i]);
		     }		     
		}
		
		//cityName4
		for (int i = cityName4.length - 1; i >= 0 ; i--) {
		     if (i==0) {
		    	 System.out.println(cityName4[i]);
		     } else {
		    	 System.out.print(cityName4[i]);
		     }		     
		}
		
		//cityName5
		for (int i = cityName5.length - 1; i >= 0 ; i--) {
		     if (i==0) {
		    	 System.out.println(cityName5[i]);
		     } else {
		    	 System.out.print(cityName5[i]);
		     } 
		}
		
		//cityName6
		for (int i = cityName6.length - 1; i >= 0 ; i--) {
		     if (i==0) {
		    	 System.out.println(cityName6[i]);
		     } else {
		    	 System.out.print(cityName6[i]);
		     } 
		}
		
		
		// Opción 2, si partimos de la creación de 0 del array nomCiutat1/cityName1:
		/*
		 * String [] nomCiutat1= {"Barcelona"};
		 *
		 *for (int i = nomCiutat1[0].length() - 1; i >= 0 ; i--) {
		 *    if (i==0) {
		 *  	 System.out.println(nomCiutat1[0].charAt(i));
		 *    } else {
		 *   	 System.out.print(nomCiutat1[0].charAt(i));
		 *    }	
		 *}
		 */
	}
}
