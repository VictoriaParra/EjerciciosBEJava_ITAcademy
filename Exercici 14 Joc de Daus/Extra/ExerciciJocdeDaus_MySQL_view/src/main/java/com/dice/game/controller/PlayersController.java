package com.dice.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dice.game.dto.Players;
import com.dice.game.exceptions.ArgumentNotFoundException;
import com.dice.game.exceptions.ArgumentNotValidException;
import com.dice.game.service.PlayersServiceImpl;

/**
 * @author Victoria Parra
 */

@RestController
@RequestMapping("/api")
public class PlayersController {

	public PlayersController() {

	}

	@Autowired
	PlayersServiceImpl playersServiceImpl;

	/**
	 * Crear jugador nuevo
	 * 
	 * @param player jugador(nombre)
	 * @return jugador
	 * @throws ArgumentNotValidException si otro jugador ya tiene ese nombre
	 */
	@PostMapping("/players")
	public Players createPlayer(@RequestBody Players player) throws ArgumentNotValidException {

		// Instanciar jugador nuevo
		Players newPlayer = new Players();

		// Si el nombre esta vacio o nulo, el jugador será "ANONIMO"
		if (player.getName() == null || player.getName().isEmpty()) {
			newPlayer.setName("ANONIMO");

		} else {
			// sino establecer como nombre el que se pasa por el body
			newPlayer.setName(player.getName().toUpperCase());
		}

		// Guardar el nuevo jugador y verificar que no hay otro jugador con ese
		// mismo nombre sino lanza excepcion
		return playersServiceImpl.createPlayer(newPlayer);
	}

	/**
	 * Devolver listado de jugadores con su porcentaje de exito("success_rate")
	 * 
	 * @return lista de jugadores
	 * @throws ArgumentNotFoundException si no existe ningun jugador
	 */
	@GetMapping("/players")
	public List<Players> getPlayers() throws ArgumentNotFoundException {

		// Si la lista de jugadores esta vacia lanzar excepcion
		if (playersServiceImpl.getPlayers().isEmpty()) {
			throw new ArgumentNotFoundException("No hay ningun jugador registrado");

		} else {
			// Devolver lista de jugadores
			return playersServiceImpl.getPlayers();
		}
	}

	/**
	 * Actualizar nombre del jugador
	 * 
	 * @param id     del jugador
	 * @param player jugador-datos
	 * @return el jugador actualizado
	 * @throws ArgumentNotValidException si el nombre ya existe
	 * @throws ArgumentNotFoundException si no existe un jugador con ese id
	 */
	@PutMapping("/players/{id}")
	public Players updatePlayerName(@PathVariable(name = "id") int id, @RequestBody Players player)
			throws ArgumentNotValidException, ArgumentNotFoundException {

		Players playerSelected = playersServiceImpl.findPlayerById(id);
		Players playerUpdated = new Players();

		// Si el nombre esta vacio o nulo, el jugador será "ANONIMO"
		if (player.getName() == null || player.getName().isEmpty()) {
			playerSelected.setName("ANONIMO");

		} else {
			// sino establecer como nombre el que se pasa por el body
			playerSelected.setName(player.getName().toUpperCase());
		}

		// Guardar actualizacion del jugador modificado
		playerUpdated = playersServiceImpl.updatePlayer(playerSelected);

		// Devolver jugador actualizado
		return playerUpdated;
	}

}
