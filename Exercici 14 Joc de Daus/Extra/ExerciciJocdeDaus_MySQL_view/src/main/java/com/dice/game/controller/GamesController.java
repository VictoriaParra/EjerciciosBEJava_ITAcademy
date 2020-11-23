package com.dice.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dice.game.dto.Games;
import com.dice.game.dto.Players;
import com.dice.game.exceptions.ArgumentNotFoundException;
import com.dice.game.service.GamesServiceImpl;
import com.dice.game.service.PlayersServiceImpl;

/**
 * @author Victoria Parra
 */

@RestController
@RequestMapping("/api")
public class GamesController {

	public GamesController() {
	}

	@Autowired
	GamesServiceImpl gamesService;

	@Autowired
	PlayersServiceImpl playersService;

	/**
	 * Crear partida
	 * 
	 * @param id del jugador
	 * @return nueva partida
	 * @throws ArgumentNotFoundException si no existe ningun jugador con ese id
	 */
	@PostMapping("/players/{id}/games")
	public Games createGame(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {

		// Lanzar excepción si no existe ningun jugador con ese id
		Players newPlayer = playersService.findPlayerById(id);

		// Instanciar nueva partida
		Games newGame = new Games();

		// Otorgar valores a los dados de manera random
		int dice1 = (int) (Math.random() * 5 + 1);
		int dice2 = (int) (Math.random() * 5 + 1);

		int result = dice1 + dice2;

		// Establecer valores de los dados de la nueva partida
		newGame.setDice1(dice1);
		newGame.setDice2(dice2);

		// Establecer el resultado de la partida, si es igual a 7 "WIN" sino "LOSE"
		if (result == 7) {
			newGame.setGameResult("WIN");
		} else {
			newGame.setGameResult("LOSE");
		}

		// Establecer el jugador de la partida
		newGame.setPlayer(newPlayer);

		// Devolver la partida creada
		return gamesService.createGame(newGame);

	}

	/**
	 * Listar partidas de un jugador según id
	 * 
	 * @param id del jugador
	 * @return lista de partidas del jugador
	 * @throws ArgumentNotFoundException si el jugador con ese id no existe o si el
	 *                                   la lista de partidas del jugador esta vacia
	 */
	@GetMapping("/players/{id}/games")
	public List<Games> getGames(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {

		// Si la lista de partidas del jugador esta vacia lanzar excepción
		// Si no existe un jugador con ese id lanzar excepción
		if (playersService.findPlayerById(id).getGame().isEmpty()) {
			throw new ArgumentNotFoundException("El jugador ID: " + id + " no tiene ninguna partida jugada.");
		} else {
			return playersService.findPlayerById(id).getGame();
		}
	}

	/**
	 * Eliminar listado de partidas del jugador
	 * 
	 * @param id del jugador
	 * @return texto informando que la eliminacion ha sido exitosa
	 * @throws ArgumentNotFoundException si no existe un jugador con ese id y si el
	 *                                   jugador no tiene ninguna partida, es decir,
	 *                                   si no hay partidas para borrar.
	 */
	@DeleteMapping("/players/{id}/games")
	public String deletePlayerGames(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {

		// Instanciar jugador y buscar jugador por id sino existe lanzar excepción
		Players newPlayer = playersService.findPlayerById(id);

		// Lanzar excepción si no hay partidas para borrar.
		if (newPlayer.getGame().isEmpty()) {
			throw new ArgumentNotFoundException(
					"El jugador id " + id + " , no tiene ninguna partida. No hay partidas por borrar.");
		} else {
			// Eliminar listado de partidas del jugador
			gamesService.deleteGames(newPlayer.getGame());
		}

		return "Las partidas del jugador ID " + id + " han sido eliminadas exitosamente";

	}

}
