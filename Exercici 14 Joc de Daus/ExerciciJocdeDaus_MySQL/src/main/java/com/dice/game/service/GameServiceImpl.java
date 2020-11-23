package com.dice.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dice.game.dao.IGameDAO;
import com.dice.game.dto.Game;
import com.dice.game.exceptions.ArgumentNotFoundException;

/**
 * @author Victoria Parra
 */

@Service
public class GameServiceImpl implements IGameService {

	@Autowired
	IGameDAO gameRepo;

	// Contar cantidad de registros por resultado de la partida
	public int countWinGames() {
		return gameRepo.countBygameResult("WIN");
	}

	// Contar total de partidas
	public int countGamesPlayed(List<Game> game) {
		return (int) gameRepo.count();
	}

	@Override
	public List<Game> getGames() throws ArgumentNotFoundException {

		// Lanzar excepción si la lista de partidas esta vacia
		if (gameRepo.findAll().isEmpty()) {
			throw new ArgumentNotFoundException("No existe ninguna partida");

		} else {
			return gameRepo.findAll();
		}
	}

	@Override
	public Game createGame(Game game) {
		return gameRepo.save(game);
	}

	@Override
	public void deleteGames(List<Game> gamesList) {
		gameRepo.deleteAll(gamesList);
	}

}
