package com.dice.game.service;

import java.util.List;

import com.dice.game.dto.Games;

/**
 * @author Victoria Parra
 */

public interface IGamesService {

	// Métodos que implementará la clase service
	
	public Games createGame(Games game); // CREATE - crear/guardar nueva partida

	public Games findGameById(int id); // READ - leer datos de una partida según id

	public void deleteGames(List<Games> gamesList); // DELETE - eliminar lista de partidas
}
