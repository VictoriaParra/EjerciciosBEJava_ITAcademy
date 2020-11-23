package com.dice.game.service;

import java.util.List;

import com.dice.game.dto.Game;

/**
 * @author Victoria Parra
 */

public interface IGameService {

	// Métodos que implementará la clase service

	public List<Game> getGames(); // Listar partidas

	public Game createGame(Game game); // CREATE - crear/guardar nueva partida

	public void deleteGames(List<Game> gamesList); // DELETE - eliminar lista de partidas

}
