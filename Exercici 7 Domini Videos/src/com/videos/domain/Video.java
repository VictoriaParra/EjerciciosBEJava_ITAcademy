package com.videos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.videos.exceptions.EmptyFieldException;

public class Video {

	// - Video: está formado por una URL, un título y una lista de tags *.
	// * Un tag es un texto con una palabra, tener en cuenta que un video puede
	// tener varios tags.

	private String url;
	private String title;

	private List<String> tags = new ArrayList<String>();

	// Constructores

	public Video() {

	}

	/**
	 * Constructor con parametros
	 * 
	 * @param mi_titulo titulo del video
	 * @param mi_url    url del video
	 * @param mi_tag    etiqueta del video
	 * @throws EmptyFieldException
	 */
	public Video(String mi_titulo, String mi_url, String mi_tag) throws EmptyFieldException {

		if (mi_url.isEmpty() || mi_titulo.isEmpty() || mi_tag.isEmpty()) {

			throw new EmptyFieldException("Ha dejado un campo vacio");

		} else {

			url = mi_url;
			title = mi_titulo;

			tags.add(mi_tag);
		}
	}

	// GETTERS Y SETTERS

	/**
	 * @return url del video
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url url del video
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return titulo del video
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return lista de etiquetas
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * Método para agregar más tags
	 * 
	 * @throws EmptyFieldException Si hay campos vacios
	 */
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
