package com.dice.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dice.game.dao.IPlayersDAO;
import com.dice.game.dto.Players;
import com.dice.game.exceptions.ArgumentNotFoundException;
import com.dice.game.exceptions.ArgumentNotValidException;

/**
 * @author Victoria Parra
 */

@Service
public class PlayersServiceImpl implements IPlayersService {

	@Autowired
	IPlayersDAO playersRepo;

	@Override
	public Players createPlayer(Players player) throws ArgumentNotValidException {

		// Lanzar excepcion si ya hay otro jugador con ese nombre y no sea "anonimo"
		if (playersRepo.countByName(player.getName()) != 0 && !player.getName().equalsIgnoreCase("anonimo")) {
			throw new ArgumentNotValidException("Este nombre ya existe");
		} else {
			// Guardar jugador
			return playersRepo.save(player);
		}
	}

	@Override
	public Players findPlayerById(int id) throws ArgumentNotFoundException {

		// Lanzar excepcion si no hay ningun jugador con ese id; Sino devolver jugador
		return playersRepo.findById(id)
				.orElseThrow(() -> new ArgumentNotFoundException("No existe ningun jugador con ID: " + id));
	}

	@Override
	public List<Players> getPlayers() {
		return playersRepo.findAll();
	}

	@Override
	public Players updatePlayer(Players player) throws ArgumentNotValidException {

		// Lanzar excepcion si ya hay otro jugador con ese nombre y no sea "anonimo"
		if (playersRepo.countByName(player.getName()) != 0 && !player.getName().equalsIgnoreCase("anonimo")) {
			throw new ArgumentNotValidException("Este nombre ya existe");
		} else {
			// Guardar jugador
			return playersRepo.save(player);
		}

	}

}
