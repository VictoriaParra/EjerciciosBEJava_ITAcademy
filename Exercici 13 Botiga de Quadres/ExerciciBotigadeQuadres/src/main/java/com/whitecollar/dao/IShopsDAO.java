package com.whitecollar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whitecollar.dto.Shops;

/**
 * Interface que extiende de la clase JpaRepository
 * 
 * @author Victoria Parra
 */

public interface IShopsDAO extends JpaRepository<Shops, Integer> {

}
