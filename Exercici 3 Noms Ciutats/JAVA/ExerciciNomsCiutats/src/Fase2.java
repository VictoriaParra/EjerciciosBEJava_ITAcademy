import java.util.Arrays;

public class Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cityName1 = "Barcelona";
		String cityName2 = "Madrid";
		String cityName3 = "Valencia";
		String cityName4 = "Malaga";
		String cityName5 = "Cadiz";
		String cityName6 = "Santander";
		
		
		//Pasar la información a un array - arrayCities
		
		String [] arrayCities= new String[6];
		arrayCities[0]= cityName1;
		arrayCities[1]= cityName2;
		arrayCities[2]= cityName3;
		arrayCities[3]= cityName4;
		arrayCities[4]= cityName5;
		arrayCities[5]= cityName6;
		
		
		
		// Mostrar por consola el array ordenado alfabeticamente
		Arrays.sort(arrayCities);
		System.out.println(Arrays.toString(arrayCities));
		
		
		
	
		
	
		
		
		
		
		
		
		
		
	}

}
