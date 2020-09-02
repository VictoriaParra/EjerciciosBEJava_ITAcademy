package com.videos.exercici;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Video {

	// - Video: está formado por una URL, un título y una lista de tags *.
	// * Un tag es un texto con una palabra, tener en cuenta que un video puede
	// tener varios tags.

	private String url;
	private String title;

	private List<String> tags = new ArrayList<String>();

	public Video(String mi_titulo, String mi_url, String mi_tag) throws EmptyFieldException {

		if (mi_url.isEmpty() || mi_titulo.isEmpty() || mi_tag.isEmpty()) {

			throw new EmptyFieldException("Ha dejado un campo vacio");

		}

		url = mi_url;
		title = mi_titulo;

		tags.add(mi_tag);
	}

	
	//Método para agregar más tags. Si hay campos vacios lanza un error.
	public void addMoreTags() throws EmptyFieldException {

		String mi_tag;
		String questionMoreTags;
		boolean hasMoreTags = true;

		while (hasMoreTags == true) {
			questionMoreTags = JOptionPane.showInputDialog("¿Quieres agregar tags? Si o No.");

			switch (questionMoreTags.toLowerCase()) {
			case "si":
				mi_tag = JOptionPane.showInputDialog("Introduce otro tag");

				if (mi_tag.isEmpty()) {
					throw new EmptyFieldException("Ha dejado un campo vacio");
				}
				tags.add(mi_tag);
				break;

			case "no":
				questionMoreTags = "no";
				hasMoreTags = false;
				break;

			default:
				JOptionPane.showMessageDialog(null, "ERROR - El valor introducido es incorrecto", "Alert",
						JOptionPane.WARNING_MESSAGE);

			}

		}

	}

	@Override
	public String toString() {
		return "Video [url=" + url + ", title=" + title + ", tags=" + tags + "]";

	}

}
