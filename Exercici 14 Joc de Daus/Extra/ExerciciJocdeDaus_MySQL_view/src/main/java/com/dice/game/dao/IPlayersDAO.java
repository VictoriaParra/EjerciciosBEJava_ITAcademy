package com.dice.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dice.game.dto.Players;

/**
 * @author Victoria Parra
 */

public interface IPlayersDAO extends JpaRepository<Players, Integer>{

	// Contar cantidad de registros por nombre
	Long countByName(String name);
}
