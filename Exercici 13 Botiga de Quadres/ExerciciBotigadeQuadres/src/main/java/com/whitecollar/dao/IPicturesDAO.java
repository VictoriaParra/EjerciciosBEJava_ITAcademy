package com.whitecollar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whitecollar.dto.Pictures;

/**
 * Interface que extiende de la clase JpaRepository
 * 
 * @author Victoria Parra
 */

public interface IPicturesDAO extends JpaRepository<Pictures, Integer> {

}
