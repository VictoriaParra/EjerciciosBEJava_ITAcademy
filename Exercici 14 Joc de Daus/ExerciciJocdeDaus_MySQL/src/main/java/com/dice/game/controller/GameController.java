package com.dice.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dice.game.dto.Game;
import com.dice.game.dto.Player;
import com.dice.game.exceptions.ArgumentNotFoundException;
import com.dice.game.service.GameServiceImpl;
import com.dice.game.service.PlayerServiceImpl;

/**
 * @author Victoria Parra
 */

@RestController
@RequestMapping("/api")
public class GameController {

	public GameController() {
	}

	@Autowired
	GameServiceImpl gameService;

	@Autowired
	PlayerServiceImpl playerService;

	/**
	 * Método para crear nueva partida y actualizar el successRate del jugador
	 * 
	 * @param id del jugador
	 * @return nueva partida
	 * @throws ArgumentNotFoundException si no existe un jugador con ese id
	 */
	@PostMapping("/players/{id}/games")
	public Game createGame(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {

		// Lanzar excepcion si no existe ningun jugador con ese id
		Player newPlayer = playerService.findPlayerById(id);

		// Instanciar nueva partida
		Game newGame = new Game();

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

		// Guardar nueva partida
		gameService.createGame(newGame);

		// Establecer porcentaje de exito del jugador
		newPlayer.setSuccessRate(newGame.calculateSuccessRate());

		// Actualizar jugador
		playerService.updatePlayer(newPlayer);

		// Devolver la partida creada
		return newGame;
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
	public List<Game> getGames(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {

		// Si la lista de partidas del jugador esta vacia lanzar excepcion
		// Si no existe un jugador con ese id lanzar excepcion
		if (playerService.findPlayerById(id).getGame().isEmpty()) {
			throw new ArgumentNotFoundException("El jugador ID: " + id + " no tiene ninguna partida jugada.");
		} else {
			return playerService.findPlayerById(id).getGame();
		}
	}

	/**
	 * Eliminar listado de partidas del jugador
	 * 
	 * @param id del jugador
	 * @return texto informando que la eliminacion ha sido exitosa
	 * @throws ArgumentNotFoundException si no existe un jugador con el id indicado
	 *                                   o, si el jugador no tiene ninguna partida,
	 *                                   es decir, si no hay partidas para borrar.
	 */
	@DeleteMapping("/players/{id}/games")
	public String deletePlayerGames(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {

		// Instanciar jugador y buscar jugador por id sino existe lanzar excepcion
		Player newPlayer = playerService.findPlayerById(id);

		// Establecer successRate a 0 ya que el jugador no posee partidas
		newPlayer.setSuccessRate(0);

		// Actualizar jugador
		playerService.updatePlayer(newPlayer);

		// Lanzar excepción si no hay partidas para borrar.
		if (newPlayer.getGame().isEmpty()) {
			throw new ArgumentNotFoundException(
					"El jugador id " + id + " , no tiene ninguna partida. No hay partidas para borrar.");
		} else {
			// Eliminar listado de partidas del jugador
			gameService.deleteGames(newPlayer.getGame());
		}

		return "Las partidas del jugador ID " + id + " han sido eliminadas exitosamente";

	}

	/**
	 * Método para devolver el porcentaje de exito de los jugadores
	 *
	 * @return texto que indica el porcentaje de exito general
	 * @throws ArgumentNotFoundException si no hay partidas
	 */
	@GetMapping("/players/ranking")
	public String getRankingRate() throws ArgumentNotFoundException {

		// Instanciar e inicializar dos variables del tipo entero
		int totalGames = gameService.countGamesPlayed(gameService.getGames());
		int winGames = gameService.countWinGames();

		// Calcular porcentaje
		int rankingRate = (winGames * 100) / totalGames;

		return "El porcentaje de éxito de todos los jugadores es de un: " + rankingRate + "%";
	}

}
