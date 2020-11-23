package com.dice.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dice.game.dao.IPlayerDAO;
import com.dice.game.dto.Player;
import com.dice.game.exceptions.ArgumentNotFoundException;
import com.dice.game.exceptions.ArgumentNotValidException;

/**
 * @author Victoria Parra
 */

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	IPlayerDAO playerRepo;

	// Listar jugadores, ordenar según el porcentaje de exito de forma ascendente
	public List<Player> findByOrderBySuccessRateAsc() {
		return playerRepo.findByOrderBySuccessRateAsc();
	}

	// Listar jugadores, ordenar según el porcentaje de exito de forma descendente
	public List<Player> findByOrderBySuccessRateDesc() {
		return playerRepo.findByOrderBySuccessRateDesc();
	}

	@Override
	public List<Player> getPlayers() {
		return playerRepo.findAll();
	}

	@Override
	public Player createPlayer(Player player) throws ArgumentNotFoundException {

		// Lanzar excepcion si ya hay otro jugador con ese nombre y no sea "anonimo"
		if (playerRepo.countByName(player.getName()) != 0 && !player.getName().equalsIgnoreCase("anonimo")) {
			throw new ArgumentNotFoundException("Este nombre ya existe");

		} else {
			// Guardar jugador
			return playerRepo.save(player);
		}
	}

	@Override
	public Player findPlayerById(String id) throws ArgumentNotFoundException {
		// Lanzar excepcion si no hay ningun jugador con ese id; Sino devolver jugador
		return playerRepo.findById(id)
				.orElseThrow(() -> new ArgumentNotFoundException("No existe ningun jugador con ID: " + id));
	}

	@Override
	public Player updatePlayerName(Player player) throws ArgumentNotValidException {

		// Lanzar excepcion si ya hay otro jugador con ese nombre y no sea "anonimo"
		if (playerRepo.countByName(player.getName()) != 0 && !player.getName().equalsIgnoreCase("anonimo")) {
			throw new ArgumentNotValidException("Este nombre ya existe");

		} else {
			// Guardar jugador
			return playerRepo.save(player);
		}
	}

	@Override
	public Player updatePlayer(Player player) {
		return playerRepo.save(player);
	}

}
