package com.dice.game.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dice.game.dto.Player;

/**
 * @author Victoria Parra
 */

public interface IPlayerDAO extends JpaRepository<Player, Integer> {

	// Contar cantidad de registros por nombre
	Long countByName(String name);

	// Listar jugadores, ordenar según el porcentaje de exito de forma ascendente
	public List<Player> findByOrderBySuccessRateAsc();

	// Listar jugadores, ordenar según el porcentaje de exito de forma descendente
	public List<Player> findByOrderBySuccessRateDesc();

}
