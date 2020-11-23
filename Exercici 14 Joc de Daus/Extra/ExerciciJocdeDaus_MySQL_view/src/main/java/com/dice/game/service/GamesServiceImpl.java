package com.dice.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dice.game.dao.IGamesDAO;
import com.dice.game.dto.Games;

/**
 * @author Victoria Parra
 */

@Service
public class GamesServiceImpl implements IGamesService {

	@Autowired
	IGamesDAO gamesRepo;

	@Override
	public Games createGame(Games game) {
		return gamesRepo.save(game);
	}

	@Override
	public Games findGameById(int id) {
		return gamesRepo.findById(id).get();
	}

	@Override
	public void deleteGames(List<Games> gamesList) {
		gamesRepo.deleteAll(gamesList);
	}
}
