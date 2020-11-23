package com.dice.game.service;

import java.util.List;

import com.dice.game.dto.Player;

/**
 * @author Victoria Parra
 */

public interface IPlayerService {

	// Métodos que implementará la clase service

	public List<Player> getPlayers(); // Listar jugadores

	public Player createPlayer(Player player); // CREATE - crear/guardar nuevo jugador

	public Player findPlayerById(int id); // READ - leer datos de un jugador según id

	public Player updatePlayerName(Player player); // UPDATE - Actualizar el nombre del jugador

	public Player updatePlayer(Player player); // UPDATE - Actualizar jugador

}
