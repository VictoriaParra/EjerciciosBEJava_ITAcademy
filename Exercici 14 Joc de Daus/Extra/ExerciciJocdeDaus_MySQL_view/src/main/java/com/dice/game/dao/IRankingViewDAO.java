package com.dice.game.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dice.game.dto.RankingView;

/**
 * @author Victoria Parra
 */

public interface IRankingViewDAO extends JpaRepository<RankingView, Integer> {

	// Listar ranking ordenar según el porcentaje de éxito de forma ascendente
	public List<RankingView> findByOrderBySuccessRateAsc();

	// Listar ranking ordenar según el porcentaje de éxito de forma descendente
	public List<RankingView> findByOrderBySuccessRateDesc();

	// Obtener el total de partidas jugadas de todos los jugadores
	@Query(value = "SELECT SUM(played_games) FROM ranking_view", nativeQuery = true)
	public int totalPlayedGames();

	// Obtener el total de partidas ganadas de todos los jugadores
	@Query(value= "select sum(won_games) from ranking_view", nativeQuery = true )
	public int totalWonGames();

}
