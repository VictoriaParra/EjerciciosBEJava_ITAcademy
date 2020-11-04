package com.whitecollar.controller;

import java.util.List;

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

import com.whitecollar.dto.Shops;
import com.whitecollar.exceptions.ArgumentNotFoundException;
import com.whitecollar.service.ShopsServiceImpl;

/**
 * @author Victoria Parra
 */

@RestController
@RequestMapping("/api")
public class ShopsController {

	@Autowired
	private ShopsServiceImpl shopsServiceImpl;

	// Listar tiendas
	@GetMapping("/shops")
	public ResponseEntity<List<Shops>> getShops() throws ArgumentNotFoundException {

		// Lanzar excepción si no existe ninguna tienda
		if (shopsServiceImpl.getShops().isEmpty()) {
			throw new ArgumentNotFoundException("No existe ninguna tienda");
		}

		// Devolver lista de tiendas con su nombre y la capacidad
		return new ResponseEntity<List<Shops>>(shopsServiceImpl.getShops(), HttpStatus.OK);
	}

	// Crear nueva tienda
	@PostMapping("/shops")
	public ResponseEntity<Shops> createShop(@RequestBody Shops shop) {
		// RequestBody: pasar nombre y capacidad de la tienda

		Shops newShop = new Shops();

		newShop.setName(shop.getName());
		newShop.setCapacity(shop.getCapacity());

		// Guardar y devolver la nueva tienda creada
		return new ResponseEntity<Shops>(shopsServiceImpl.createShop(newShop), HttpStatus.CREATED);
	}

	// ---------------------------------------------------------------------------------------------------
	// Funcionalidades/Requests adicionales(no estan requeridas en la consigna)

	@GetMapping("/shops/{id}")
	public ResponseEntity<Shops> findShopById(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {
		// Devolver tienda segun id sino existe lanzar excepción
		return new ResponseEntity<Shops>(shopsServiceImpl.findShopById(id), HttpStatus.OK);
	}

	@PutMapping("/shops/{id}")
	public ResponseEntity<Shops> updateShop(@PathVariable(name = "id") int id, @RequestBody Shops shop)
			throws ArgumentNotFoundException {

		Shops shopSelected = new Shops();
		Shops shopUpdated = new Shops();

		shopSelected = shopsServiceImpl.findShopById(id);

		shopSelected.setName(shop.getName());
		shopSelected.setCapacity(shop.getCapacity());

		// Guardar actualizacion de la tienda modificada
		shopUpdated = shopsServiceImpl.updateShop(shopSelected);

		// Devolver tienda actualizada
		return new ResponseEntity<Shops>(shopUpdated, HttpStatus.CREATED);
	}

	@DeleteMapping("/shops/{id}")
	public ResponseEntity<String> deleteShop(@PathVariable(name = "id") int id) {
		// Borrar tienda segun id
		shopsServiceImpl.deleteShop(id);

		// Devolver mensaje si se elimina la tienda
		return new ResponseEntity<>("La tienda con ID: " + id + " se han eliminado correctamente", HttpStatus.OK);
	}
}
