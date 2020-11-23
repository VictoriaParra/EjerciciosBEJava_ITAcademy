package com.dice.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dice.game.dto.Game;

/**
 * @author Victoria Parra
 */

public interface IGameDAO extends JpaRepository<Game, Integer> {

	// Contar cantidad de registros por resultado de la partida
	int countBygameResult(String gameResult);

}
