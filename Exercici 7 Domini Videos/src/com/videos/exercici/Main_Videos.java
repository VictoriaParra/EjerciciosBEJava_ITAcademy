package com.videos.exercici;

import javax.swing.JOptionPane;

public class Main_Videos {

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

		String questionCreateVideo;
		String questionSeeList;

		boolean isUserOk = false;
		boolean isVideoCreated = true;
		boolean isThereList = true;

		Usuario user = null;
		Video userVideo;

		// ---------------------------------------------------------------CREAR USUARIO
		while (isUserOk == false) {

			try {

				user = new Usuario(JOptionPane.showInputDialog("Introduzca su nombre"),
						JOptionPane.showInputDialog("Introduzca su apellido"),
						JOptionPane.showInputDialog("Introduzca su contraseña"));

			} catch (EmptyFieldException e) {

				JOptionPane.showMessageDialog(null, "Ha dejado campos vacios. \nVuelva a cargar los datos.", "Alert",
						JOptionPane.WARNING_MESSAGE);
				continue;

			} catch (NullPointerException ex) {
				// Excepción que lanza el programa si se cierra la ventana en vez de completar
				// los datos que se pide o si se pone cancelar.
				JOptionPane.showMessageDialog(null, "Ha cerrado las ventanas. \nVuelva a cargar los datos.", "Alert",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}

			isUserOk = true;

		}

		System.out.println(user.getUserData());

		// -----------------------------------------------------------------CREAR VIDEO
		while (isVideoCreated == true) {

			try {

				questionCreateVideo = JOptionPane.showInputDialog("¿Desea crear un video? SI o NO");

				switch (questionCreateVideo.toLowerCase()) {
				case "si":

					try {
						userVideo = new Video(JOptionPane.showInputDialog("Introduce el titulo del video"),
								JOptionPane.showInputDialog("Introduce la URL del video"),
								JOptionPane.showInputDialog("Introduzca un Tag"));

						userVideo.addMoreTags(); // Para agregar mas tags a la lista.

					} catch (EmptyFieldException e) {
						JOptionPane.showMessageDialog(null, "Ha dejado campos vacios. \nVuelva a empezar, gracias.",
								"Alert", JOptionPane.WARNING_MESSAGE);

						continue;
					}

					user.addVideo(userVideo); // se agrega el video a la lista de videos del usuario.
					break;

				case "no":
					isVideoCreated = false;
					break;

				default:
					JOptionPane.showMessageDialog(null, "Ha introducido mal la palabra", "Alert",
							JOptionPane.WARNING_MESSAGE);
					break;
				}

			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Ha cerrado las ventanas. \nVuelva a cargar los datos.", "Alert",
						JOptionPane.WARNING_MESSAGE);

			}

		}

		// -----------------------------------------------------------------VER LISTADO
		while (isThereList == true) {

			try {

				questionSeeList = JOptionPane.showInputDialog("¿Desea ver su lista de videos? SI o NO");

				if (questionSeeList.equalsIgnoreCase("si")) {
					try {

						user.printVideosList();// se imprime en consola el listado.

					} catch (EmptyFieldException exc) {
						JOptionPane.showMessageDialog(null,
								"Su listado se encuentra vacio.\nMuchas gracias y hasta la proxima!", "Alert",
								JOptionPane.WARNING_MESSAGE);
					}

					isThereList = false;

				} else if (questionSeeList.equalsIgnoreCase("no")) {
					JOptionPane.showMessageDialog(null, "Muchas gracias y hasta la proxima!");
					isThereList = false;

				} else {
					JOptionPane.showMessageDialog(null, "Ha introducido mal la palabra", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}

			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Ha cerrado las ventanas. \nVuelva a cargar los datos.", "Alert",
						JOptionPane.WARNING_MESSAGE);

			}

		}
	}
}
