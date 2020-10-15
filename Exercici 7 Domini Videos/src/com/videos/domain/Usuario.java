package com.videos.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.videos.exceptions.EmptyFieldException;

public class Usuario {

	// - Usuario: está formado por un nombre, apellido, password y una fecha de
	// registro.

	private String name;
	private String surname;
	private String password;

	private Date registrationDate;

	private List<Video> videos = new ArrayList<Video>();

	/**
	 * Constructor por defecto
	 */
	public Usuario() {

	}

	/**
	 * Constructor con parametros
	 * 
	 * @param nombre     nombre del usuario
	 * @param apellido   apellido del usuario
	 * @param contraseña contraseña del usuario
	 * @throws EmptyFieldException  si el campo esta vacio
	 * @throws NullPointerException si es nulo
	 */
	public Usuario(String nombre, String apellido, String contraseña) throws EmptyFieldException, NullPointerException {

		if (nombre.isEmpty() || apellido.isEmpty() || contraseña.isEmpty()) {

			throw new EmptyFieldException("Ha dejado un campo vacio");

		} else {

			name = nombre;

			surname = apellido;

			password = contraseña;

			registrationDate = new Date();
		}

	}

	/**
	 * Método para agregar vido a la lista de videos del usuario
	 * 
	 * @param video
	 */
	public void addVideo(Video video) {

		this.videos.add(video);

	}

	// GETTERS Y SETTERS

	/**
	 * @return nombre del usuario
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name nombre del usuario
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return apellido del usuario
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname apellido del usuario
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return contraseña del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password contraseña del usuario
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return fecha de registro del usuario
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate fecha de registro del usuario
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return lista de videos del usuario
	 */
	public List<Video> getVideos() {
		return videos;
	}

	/**
	 * @param videos lista de videos
	 */
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "Usuario [name= " + name + ", surname= " + surname + ", password= " + password + ", registrationDate= "
				+ registrationDate + "]";
	}

}
