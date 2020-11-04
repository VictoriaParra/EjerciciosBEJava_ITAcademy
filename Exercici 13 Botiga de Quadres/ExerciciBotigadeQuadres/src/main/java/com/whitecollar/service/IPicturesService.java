package com.whitecollar.service;

import java.util.List;

/**
 * @author Victoria Parra
 */

import com.whitecollar.dto.Pictures;

/**
 * @author Victoria Parra
 */

public interface IPicturesService {

	// Métodos CRUD

	public List<Pictures> getPictures(); // Listar cuadros

	public Pictures createPicture(Pictures picture); // CREATE - crear/guardar nuevo cuadro

	public Pictures findPictureById(int id); // READ - leer datos de un cuadro según id

	public Pictures updatePicture(Pictures picture); // UPDATE - actualizar datos del cuadro

	public void deletePictures(List<Pictures> picturesList); // DELETE - eliminar lista de cuadros

}
