package com.whitecollar.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whitecollar.dto.Pictures;
import com.whitecollar.dto.Shops;
import com.whitecollar.exceptions.ArgumentNotFoundException;
import com.whitecollar.service.PicturesServiceImpl;
import com.whitecollar.service.ShopsServiceImpl;

/**
 * @author Victoria Parra
 */

@RestController
@RequestMapping("/api")
public class PicturesController {

	@Autowired
	private PicturesServiceImpl picturesServiceImpl;

	@Autowired
	private ShopsServiceImpl shopService;

	// Añadir nuevo cuadro a una tienda según el id
	@PostMapping("/shops/{id}/pictures")
	public ResponseEntity<Pictures> addPictureToShop(@PathVariable(name = "id") int id, @RequestBody Pictures picture)
			throws ArgumentNotFoundException {

		Shops newShop = shopService.findShopById(id);
		Pictures newPicture = new Pictures();

		newPicture.setName(picture.getName());
		// Si el nombre es nulo o esta vacio, estableber nombre como "ANONIMO"
		if (picture.getAuthor_name() == null || picture.getAuthor_name().isEmpty()) {
			newPicture.setAuthor_name("ANONIMO");
		} else {
			newPicture.setAuthor_name(picture.getAuthor_name());
		}
		newPicture.setPrice(picture.getPrice());
		newPicture.setEntry_date(picture.getEntry_date());
		newPicture.setShop(newShop);

		// Devolver cuadro creado
		return new ResponseEntity<Pictures>(picturesServiceImpl.createPicture(newPicture), HttpStatus.CREATED);
	}

	// Listar cuadros según id de la tienda
	@GetMapping("/shops/{id}/pictures")
	public ResponseEntity<List<Pictures>> findPicturesByShopId(@PathVariable(name = "id") int id)
			throws ArgumentNotFoundException {

		Shops newShop = shopService.findShopById(id);

		// Lanzar excepción si no existe ningun cuadro
		if (newShop.getPictures().isEmpty()) {
			throw new ArgumentNotFoundException("No existe ningún cuadro en esa tienda");
		} else {
			return new ResponseEntity<List<Pictures>>(picturesServiceImpl.getPictures().stream()
					.filter(picture -> picture.getShop().equals(newShop)).collect(Collectors.toList()), HttpStatus.OK);
		}
	}

	// Eliminar todas las pinturas de una tienda en especifico
	@DeleteMapping("/shops/{id}/pictures")
	public ResponseEntity<String> setFirePicture(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {

		// Corroborar si la tienda existe y luego borrar los cuadros de esa tienda.
		picturesServiceImpl.deletePictures(shopService.findShopById(id).getPictures());

		return new ResponseEntity<>("Los collares se han eliminado correctamente", HttpStatus.OK);
	}

	// ------------------------------------------------------------------------------------------
	// Funcionalidades adicionales(no estan requeridas en la consigna)

	// Método Listar cuadros
	@GetMapping("/pictures")
	public ResponseEntity<List<Pictures>> getPictures() throws ArgumentNotFoundException {

		// Lanzar excepción si no existe ningun cuadro
		if (picturesServiceImpl.getPictures().isEmpty()) {
			throw new ArgumentNotFoundException("No existe ningún cuadro");
		} else {
			return new ResponseEntity<List<Pictures>>(picturesServiceImpl.getPictures(), HttpStatus.OK);
		}
	}

	// Método para traer datos del cuadro según id.
	@GetMapping("/pictures/{id}")
	public ResponseEntity<Pictures> findPictureById(@PathVariable(name = "id") int id)
			throws ArgumentNotFoundException {
		return new ResponseEntity<Pictures>(picturesServiceImpl.findPictureById(id), HttpStatus.OK);
	}

	// Método para actualizar datos de un cuadro
	@PutMapping("/pictures/{id}")
	public ResponseEntity<Pictures> updatePicture(@PathVariable(name = "id") int id, @RequestBody Pictures picture)
			throws ArgumentNotFoundException {

		// Instanciar e inicializar cuadros
		Pictures pictureSelected = new Pictures();
		Pictures pictureUpdated = new Pictures();

		// pictureSelected es igual al cuadro seleccionado(previamente se corrobora que
		// exista un cuadro con ese id sino lanza una excepcion)
		pictureSelected = picturesServiceImpl.findPictureById(id);

		pictureSelected.setName(picture.getName());
		pictureSelected.setAuthor_name(picture.getAuthor_name());
		pictureSelected.setEntry_date(picture.getEntry_date());
		pictureSelected.setPrice(picture.getPrice());
		pictureSelected.setShop(picture.getShop());

		//Guardar/actualizar cuadro
		pictureUpdated = picturesServiceImpl.updatePicture(pictureSelected);

		//Devolver el cuadro actualizado
		return new ResponseEntity<Pictures>(pictureUpdated, HttpStatus.CREATED);
	}

}
