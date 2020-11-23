package com.dice.game.service;

import java.util.List;

import com.dice.game.dto.Players;

/**
 * @author Victoria Parra
 */

public interface IPlayersService {

	// Métodos que implementará la clase service

	public List<Players> getPlayers(); // Listar jugadores

	public Players createPlayer(Players player); // CREATE - crear/guardar nuevo jugador

	public Players findPlayerById(int id); // READ - leer datos de un jugador según id

	public Players updatePlayer(Players player); // UPDATE - Actualizar el nombre del jugador

}
