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

import com.dice.game.dto.Player;
import com.dice.game.exceptions.ArgumentNotFoundException;
import com.dice.game.exceptions.ArgumentNotValidException;
import com.dice.game.service.PlayerServiceImpl;

/**
 * @author Victoria Parra
 */

@RestController
@RequestMapping("/api")
public class PlayerController {

	public PlayerController() {
	}

	@Autowired
	PlayerServiceImpl playerService;

	/**
	 * Crear jugador nuevo
	 * 
	 * @param player jugador(nombre)
	 * @return jugador
	 * @throws ArgumentNotValidException si otro jugador ya tiene ese nombre
	 */
	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player) throws ArgumentNotValidException {

		// Instanciar jugador nuevo
		Player newPlayer = new Player();

		// Si el nombre esta vacio o nulo, el jugador será "ANONIMO"
		if (player.getName() == null || player.getName().isEmpty()) {
			newPlayer.setName("ANONIMO");

		} else {
			// sino establecer como nombre el que se pasa en el body
			newPlayer.setName(player.getName().toUpperCase());

		}
		// Guardar el nuevo jugador y verificar que no hay otro jugador con ese
		// mismo nombre sino, lanzar excepción
		return playerService.createPlayer(newPlayer);
	}

	/**
	 * Actualizar nombre del jugador
	 * 
	 * @param id     del jugador
	 * @param player jugador-datos
	 * @return el jugador actualizado
	 * @throws ArgumentNotValidException si el nombre ya existe
	 * @throws ArgumentNotFoundException si no existe un jugador con el id indicado
	 */
	@PutMapping("/players/{id}")
	public Player changeNamePlayer(@PathVariable(name = "id") int id, @RequestBody Player player)
			throws ArgumentNotValidException, ArgumentNotFoundException {

		// Instanciar dos objetos de tipo player
		// Lanzar excepción si el no se encuentra un jugador con el id indicado
		Player playerSelected = playerService.findPlayerById(id);
		Player playerUpdated = new Player();

		// Si el nombre esta vacío o nulo, el jugador será "ANONIMO"
		if (player.getName() == null || player.getName().isEmpty()) {
			playerSelected.setName("ANONIMO");

		} else {
			// sino establecer como nombre el que se pasa en el body
			playerSelected.setName(player.getName().toUpperCase());
		}
		// Guardar actualizacion del jugador modificado
		playerUpdated = playerService.updatePlayerName(playerSelected);

		// Devolver jugador actualizado
		return playerUpdated;
	}

	/**
	 * Devolver listado de jugadores con su porcentaje de exito("success_rate")
	 * 
	 * @return lista de jugadores
	 * @throws ArgumentNotFoundException si no existe ningun jugador
	 */
	@GetMapping("/players")
	public List<Player> getPlayers() throws ArgumentNotFoundException {

		// Si la lista de jugadores esta vacia lanzar excepcion
		if (playerService.getPlayers().isEmpty()) {
			throw new ArgumentNotFoundException("No hay ningun jugador registrado");

		} else {
			// Devolver lista de jugadores
			return playerService.getPlayers();
		}
	}

	/**
	 * Devolver jugador con peor porcentaje de exito
	 * 
	 * @return jugador con porcentaje de exito mas bajo
	 */
	@GetMapping("/players/ranking/loser")
	public Player getLoserPlayer() {

		// Devolver jugador en la posición(index) 0 de la lista de jugadores ordenado
		// según el successRate de forma ascendente
		return playerService.findByOrderBySuccessRateAsc().get(0);
	}

	/**
	 * Devolver jugador con el mejor porcentaje de exito
	 * 
	 * @return jugador con porcentaje de exito mas alto
	 */
	@GetMapping("/players/ranking/winner")
	public Player getWinnerPlayer() {

		// Devolver jugador en la posición(index) 0 de la lista de jugadores ordenado,
		// según el successRate de forma descendente
		return playerService.findByOrderBySuccessRateDesc().get(0);
	}

}
