package com.dice.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dice.game.dto.Game;
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

		// Si el nombre esta vacío o nulo, el jugador será "ANONIMO"
		if (player.getName() == null || player.getName().isEmpty()) {
			newPlayer.setName("ANONIMO");

		} else {
			// sino establecer como nombre el que se pasa en el body
			newPlayer.setName(player.getName().toUpperCase());

		}
		// Guardar el nuevo jugador y verificar que no hay otro jugador con ese
		// mismo nombre sino, lanzar excepcion
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
	public Player changeNamePlayer(@PathVariable(name = "id") String id, @RequestBody Player player)
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
		// Guardar actualización del jugador modificado
		playerUpdated = playerService.updatePlayerName(playerSelected);

		// Devolver jugador actualizado
		return playerUpdated;
	}

	/**
	 * Método para crear nueva partida y actualizar el successRate del jugador
	 * 
	 * @param id del jugador
	 * @return nueva partida
	 * @throws ArgumentNotFoundException si no existe un jugador con el id indicado
	 */
	@PostMapping("/players/{id}/games")
	public Game createGame(@PathVariable(name = "id") String id) throws ArgumentNotFoundException {

		// Lanzar excepción si no existe ningún jugador con el id indicado
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

		// Agregar nueva partida a la lista de partidas del jugador
		newPlayer.getGame().add(newGame);

		// Establecer porcentaje de exito del jugador
		newPlayer.setSuccessRate(newGame.calculateSuccessRate(newPlayer));

		// Actualizar jugador
		playerService.updatePlayer(newPlayer);

		// Devolver la partida creada
		return newGame;
	}

	/**
	 * Devolver listado de jugadores con su porcentaje de exito("success_rate")
	 * 
	 * @return lista de jugadores
	 * @throws ArgumentNotFoundException si no existe ningun jugador
	 */
	@GetMapping("/players")
	public List<Player> getPlayers() throws ArgumentNotFoundException {

		// Si la lista de jugadores esta vacia lanzar excepción
		if (playerService.getPlayers().isEmpty()) {
			throw new ArgumentNotFoundException("No hay ningun jugador registrado");

		} else {
			// Devolver lista de jugadores
			return playerService.getPlayers();
		}
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
	public List<Game> getGames(@PathVariable(name = "id") String id) throws ArgumentNotFoundException {

		// Si la lista de partidas del jugador esta vacia lanzar excepción
		// Si no existe un jugador con ese id lanzar excepción
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
	public String deletePlayerGames(@PathVariable(name = "id") String id) throws ArgumentNotFoundException {

		// Instanciar jugador y buscar jugador por id sino existe lanzar excepcion
		Player newPlayer = playerService.findPlayerById(id);

		// Lanzar excepción si no hay partidas para borrar.
		if (newPlayer.getGame().isEmpty()) {
			throw new ArgumentNotFoundException(
					"El jugador id " + id + " , no tiene ninguna partida. No hay partidas para borrar.");
		} else {
			// Eliminar listado de partidas del jugador
			newPlayer.getGame().removeAll(newPlayer.getGame());
		}

		// Establecer successRate a 0 ya que el jugador no posee partidas
		newPlayer.setSuccessRate(0);

		// Guardar jugador
		playerService.updatePlayer(newPlayer);

		return "Las partidas del jugador ID " + id + " han sido eliminadas exitosamente";
	}

	/**
	 * Método para devolver el porcentaje de exito de los jugadores
	 *
	 * @return texto que indica el porcentaje de exito general
	 * @throws ArgumentNotFoundException si no hay jugadores
	 * @throws ArgumentNotValidException si no hay partidas
	 */
	@GetMapping("/players/ranking")
	public String getRankingRate() throws ArgumentNotFoundException, ArgumentNotValidException {

		// Instanciar e inicializar dos variables del tipo entero
		int totalGames = 0;
		int wonGames = 0;

		// Por cada jugador de la lista de jugadores, obtener su lista de partidas
		for (Player player : playerService.getPlayers()) {

			// Por cada partida de la lista de partidas incrementar el valor del totalGames
			for (Game game : player.getGame()) {
				totalGames++;

				// Si la partida tiene como resultado win, incrementar el valor de wonGames
				if (game.getGameResult().equalsIgnoreCase("win")) {
					wonGames++;
				}
			}
		}

		if (totalGames == 0) {
			throw new ArgumentNotValidException("No hay ninguna partida. El dividor no puede ser 0.");
		} else {
			// Calcular porcentaje
			int rankingRate = (wonGames * 100) / totalGames;

			return "El porcentaje de éxito de todos los jugadores es de un: " + rankingRate + "%";
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
	 * Devolver jugador con el mejor porcentaje de éxito
	 * 
	 * @return jugador con porcentaje de éxito mas alto
	 */
	@GetMapping("/players/ranking/winner")
	public Player getWinnerPlayer() {

		// Devolver jugador en la posición(index) 0 de la lista de jugadores ordenado,
		// según el successRate de forma descendente
		return playerService.findByOrderBySuccessRateDesc().get(0);
	}

}
