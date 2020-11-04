package com.whitecollar.service;

import java.util.List;

import com.whitecollar.dto.Shops;

/**
 * @author Victoria Parra
 */

public interface IShopsService {

	// Métodos CRUD

	public List<Shops> getShops(); // Listar tiendas

	public Shops createShop(Shops shop); // CREATE - crear/guardar nueva tienda

	public Shops findShopById(int id); // READ - leer datos de una tienda según id

	public Shops updateShop(Shops shop); // UPDATE - actualizar datos de la tienda

	public void deleteShop(int id); // DELETE - eliminar tienda según id

}
