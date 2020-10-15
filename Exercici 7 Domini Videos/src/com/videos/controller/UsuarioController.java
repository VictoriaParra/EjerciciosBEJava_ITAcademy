package com.videos.controller;

import com.videos.domain.Usuario;
import com.videos.domain.Video;
import com.videos.exceptions.EmptyFieldException;
import com.videos.persistence.UsuarioRepository;

public class UsuarioController {

	private Usuario user;

	private UsuarioRepository repo = new UsuarioRepository();

	// Constructor
	public UsuarioController() {

	}

	// Método para crear usuario
	public void createUsuario(String nombre, String apellido, String contraseña)
			throws EmptyFieldException, NullPointerException {

		user = new Usuario(nombre, apellido, contraseña);

		repo.addUser(user);
	}

	// Método para crear video
	public void createVideo(String mi_titulo, String mi_url, String mi_tag) throws EmptyFieldException {

		Video video = new Video(mi_titulo, mi_url, mi_tag);

		video.addMoreTags();

		user.addVideo(video);

	}

	/**
	 * Metodo para obtener los datos del usuario
	 * 
	 * @return los datos del usuario
	 */
	public String getUserData() {

		return user.toString();
	}

	/**
	 * Método para imprimir listado de videos
	 * 
	 * @throws EmptyFieldException
	 */
	public void printVideosList() throws EmptyFieldException {

		if (user.getVideos().isEmpty()) {
			throw new EmptyFieldException("El listado esta vacio");
		}

		System.out.println("Su listado de videos es:");

		for (Video v : user.getVideos()) {

			System.out.println(v.toString());

		}

		System.out.println("\nMuchas gracias y hasta la proxima!");

	}

}
