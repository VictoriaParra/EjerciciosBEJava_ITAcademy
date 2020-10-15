package com.videos.view;

import javax.swing.JOptionPane;

import com.videos.controller.UsuarioController;
import com.videos.exceptions.EmptyFieldException;

public class Preguntas {

	/*
	 * Clase para gestionar la interaccion con el usuario, que luego utilizara la
	 * clase main.
	 */

	private static UsuarioController controller = new UsuarioController();

	String questionCreateVideo;
	String questionSeeList;

	boolean isUserCreated = false;
	boolean isVideoCreated = true;
	boolean isThereList = true;

	// Constructor
	public Preguntas() {

	}

	public void questionCreateUser() {

		while (isUserCreated == false) {

			try {
				controller.createUsuario(JOptionPane.showInputDialog("Introduzca su nombre"),
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

			isUserCreated = true;

		}
	}

	public void getDataUser() {

		System.out.println(controller.getUserData() + "\n");
	}

	public void questionCreateVideo() {

		while (isVideoCreated == true) {

			try {

				questionCreateVideo = JOptionPane.showInputDialog("¿Desea crear un video? SI o NO");

				switch (questionCreateVideo.toLowerCase()) {
				case "si":

					try {
						controller.createVideo(JOptionPane.showInputDialog("Introduce el titulo del video"),
								JOptionPane.showInputDialog("Introduce la URL del video"),
								JOptionPane.showInputDialog("Introduzca un Tag"));

					} catch (EmptyFieldException e) {
						JOptionPane.showMessageDialog(null, "Ha dejado campos vacios. \nVuelva a empezar, gracias.",
								"Alert", JOptionPane.WARNING_MESSAGE);

						continue;
					}

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

	}

	public void questionGetList() {

		while (isThereList == true) {

			try {

				questionSeeList = JOptionPane.showInputDialog("¿Desea ver su lista de videos? SI o NO");

				if (questionSeeList.equalsIgnoreCase("si")) {
					try {

						controller.printVideosList();// se imprime en consola el listado.

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
