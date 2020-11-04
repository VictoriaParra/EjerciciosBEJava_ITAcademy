package com.whitecollar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitecollar.dao.IShopsDAO;
import com.whitecollar.dto.Shops;
import com.whitecollar.exceptions.ArgumentNotFoundException;

/**
 * @author Victoria Parra
 */

@Service
public class ShopsServiceImpl implements IShopsService {

	@Autowired
	private IShopsDAO repo;

	@Override
	public List<Shops> getShops() {
		return repo.findAll();
	}

	@Override
	public Shops createShop(Shops shop) {
		return repo.save(shop);
	}

	@Override
	public Shops findShopById(int id) throws ArgumentNotFoundException {

		if (repo.existsById(id) == false) {
			throw new ArgumentNotFoundException("No existe ninguna tienda con ID: " + id);
		} else {
			return repo.findById(id).get();
		}
	}

	@Override
	public Shops updateShop(Shops shop) {
		return repo.save(shop);
	}

	@Override
	public void deleteShop(int id) {
		repo.deleteById(id);
	}

}
