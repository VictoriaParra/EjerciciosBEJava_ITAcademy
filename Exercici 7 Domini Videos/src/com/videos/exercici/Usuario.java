package com.videos.exercici;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {

	// - Usuario: está formado por un nombre, apellido, password y una fecha de
	// registro.

	private String name;
	private String surname;
	private String password;

	private Date registrationDate;

	private List<Video> videos = new ArrayList<Video>();

	public Usuario(String nombre, String apellido, String contraseña) throws EmptyFieldException, NullPointerException {

		if (nombre.isEmpty() || apellido.isEmpty() || contraseña.isEmpty()) {

			throw new EmptyFieldException("Ha dejado un campo vacio");

		}

		name = nombre;

		surname = apellido;

		password = contraseña;

		registrationDate = new Date();

	}

	public String getUserData() { // getter, imprime info del usuario

		return "Nombre: " + name + "\nApellido: " + surname + "\nContraseña: " + password + "\nFecha de alta: "
				+ registrationDate + "\n";
	}

	public void addVideo(Video video) {

		// Agregar video a la lista videos del objeto Usuario
		this.videos.add(video);
	}

	// Imprimir el listado de videos del usuario ( titulo, url y lista de tags)
	public void printVideosList() throws EmptyFieldException {

		if (videos.isEmpty()) {
			throw new EmptyFieldException("El listado esta vacio");
		}

		System.out.println("Su listado de videos es:");

		for (Video v : videos) {

			System.out.println(v.toString());
			
		}

		System.out.println("\nMuchas gracias y hasta la proxima!");

	}

}
