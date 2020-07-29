import java.util.Scanner;

public class Fase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creación de 6 variables vacias tipo string.
		String cityName1 = "";
		String cityName2 = "";
		String cityName3 = "";
		String cityName4 = "";
		String cityName5 = "";
		String cityName6 = "";

		// Pedir por consola que se introduzcan los nombres.
		Scanner entrada=new Scanner(System.in);
		
		// Introducir por teclado, los nombres de las siguientes ciudades
		// Barcelona, Madrid, Valencia, Malaga, Cadiz y Santander.
		System.out.print("Introduce CityName1: ");
		cityName1=entrada.nextLine();	
		
		System.out.print("Introduce CityName2: ");
		cityName2=entrada.nextLine();
		
		System.out.print("Introduce CityName3: ");
		cityName3=entrada.nextLine();
		
		System.out.print("Introduce CityName4: ");
		cityName4=entrada.nextLine();
		
		System.out.print("Introduce CityName5: ");
		cityName5=entrada.nextLine();
		
		System.out.print("Introduce CityName6: ");
		cityName6=entrada.nextLine();
		
		entrada.close();
		
		//Mostrar por consola el nombre de las 6 ciudades.
		System.out.println("Las ciudades elegidas son: "+cityName1+", "+cityName2+", "+cityName3+", "+cityName4+", "+cityName5+" y "+ cityName6);
		
		
	}

}
