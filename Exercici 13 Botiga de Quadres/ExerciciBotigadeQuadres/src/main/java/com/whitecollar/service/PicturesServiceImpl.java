package com.whitecollar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitecollar.dao.IPicturesDAO;
import com.whitecollar.dto.Pictures;
import com.whitecollar.exceptions.ArgumentNotFoundException;

/**
 * @author Victoria Parra
 */

@Service
public class PicturesServiceImpl implements IPicturesService {

	@Autowired
	private IPicturesDAO iPictureDAO;

	@Override
	public List<Pictures> getPictures() {
		return iPictureDAO.findAll();
	}

	@Override
	public Pictures createPicture(Pictures picture) {
		return iPictureDAO.save(picture);
	}

	@Override
	public Pictures findPictureById(int id) throws ArgumentNotFoundException {
		
		// Lanzar excepcion si no existe ningun cuadro con ese id
		if (iPictureDAO.existsById(id) == false) {
			throw new ArgumentNotFoundException("No existe ninguna tienda con ID: " + id);
		} else {
			return iPictureDAO.findById(id).get();
		}
	}

	@Override
	public Pictures updatePicture(Pictures picture) {
		return iPictureDAO.save(picture);
	}

	@Override
	public void deletePictures(List<Pictures> picturesList) {
		iPictureDAO.deleteAll(picturesList);
	}

}
