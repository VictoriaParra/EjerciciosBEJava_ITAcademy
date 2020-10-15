package com.videos.view;

public class Main_Videos {

	private static Preguntas pregunta = new Preguntas();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Un usuario puede crear nuevos vídeos y ver un listado de sus videos. Puedes
		 * hacer uso de la clase Scanner o JoptionPane para interactuar con el usuario.
		 */

		/*
		 * La estructura no debe permitir añadir campos vacíos, en caso de que haya debe
		 * devolver una excepción. Hs de hacer uso de java Exceptions.
		 */

		pregunta.questionCreateUser();

		pregunta.getDataUser();

		pregunta.questionCreateVideo();

		pregunta.questionGetList();

	}
}
