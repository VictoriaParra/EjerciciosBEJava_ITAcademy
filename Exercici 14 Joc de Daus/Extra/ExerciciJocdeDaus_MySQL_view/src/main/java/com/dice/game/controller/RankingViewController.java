package com.dice.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dice.game.dto.Players;
import com.dice.game.exceptions.ArgumentNotFoundException;
import com.dice.game.service.PlayersServiceImpl;
import com.dice.game.service.RankingViewServiceImpl;

/**
 * @author Victoria Parra
 */

@RestController
@RequestMapping("/api")
public class RankingViewController {

	public RankingViewController() {
	}

	@Autowired
	private PlayersServiceImpl playersService;

	@Autowired
	private RankingViewServiceImpl rankingService;

	/**
	 * Devolver jugador con peor porcentaje de exito
	 * 
	 * @return jugador con porcentaje de exito mas bajo
	 * @throws ArgumentNotFoundException si no existe un jugador con ese id
	 */
	@GetMapping("/players/ranking/loser")
	public Players getLoserPlayer() throws ArgumentNotFoundException {

		// id_ranking es igual al id_players debido al @MapsId
		int id = rankingService.findByOrderBySuccessRateAsc().get(0).getId();

		// Devolver jugador segun id, lanzar excepcion si no existe
		return playersService.findPlayerById(id);
	}

	/**
	 * Devolver jugador con el mejor porcentaje de exito
	 * 
	 * @return jugador con porcentaje de exito mas alto
	 * @throws ArgumentNotFoundException si no existe un jugador con ese id
	 */
	@GetMapping("/players/ranking/winner")
	public Players getWinnerPlayer() throws ArgumentNotFoundException {

		// id_ranking es igual al id_players debido al @MapsId
		int id = rankingService.findByOrderBySuccessRateDesc().get(0).getId();

		// Devolver jugador segun id, lanzar excepcion si no existe
		return playersService.findPlayerById(id);

	}

	/**
	 * Método para devolver el porcentaje de exito de los jugadores
	 * 
	 * @return texto que indica el porcentaje de éxito general
	 * @throws ArgumentNotFoundException si no hay partidas
	 */
	@GetMapping("/players/ranking")
	public String getPlayersSuccessRate() throws ArgumentNotFoundException {

		// Instanciar e inicializar dos variables del tipo entero
		// Lanzar excepción si no hay partidas ya que no se puede dividir por 0
		int totalGames = rankingService.getTotalGames();
		int totalWonGames = rankingService.getTotalWonGames();

		// Calcular porcentaje
		int rankingRate = (totalWonGames * 100) / totalGames;

		return "El porcentaje de éxito de todos los jugadores es de un: " + rankingRate + "%";

	}

}
