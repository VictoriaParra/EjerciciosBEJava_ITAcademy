package com.dice.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dice.game.dao.IRankingViewDAO;
import com.dice.game.dto.RankingView;
import com.dice.game.exceptions.ArgumentNotFoundException;

/**
 * @author Victoria Parra
 */

@Service
public class RankingViewServiceImpl implements IRankingViewService {

	@Autowired
	private IRankingViewDAO rankingRepo;

	// Devolver total de partidas jugadas
	public int getTotalGames() throws ArgumentNotFoundException {

		// Lanzar excepción si los jugadores no tienen partidas
		if (rankingRepo.totalPlayedGames() == 0) {
			throw new ArgumentNotFoundException("No hay partidas");
		} else {
			return rankingRepo.totalPlayedGames();
		}
	}

	// Devolver total de partidas ganadas
	public int getTotalWonGames() {
		return rankingRepo.totalWonGames();
	}

	// Listar jugadores, ordenar según el porcentaje de exito de forma ascendente
	public List<RankingView> findByOrderBySuccessRateAsc() {
		return rankingRepo.findByOrderBySuccessRateAsc();
	}

	// Listar jugadores, ordenar según el porcentaje de exito de forma descendente
	public List<RankingView> findByOrderBySuccessRateDesc() {
		return rankingRepo.findByOrderBySuccessRateDesc();
	}

	@Override
	public RankingView findRankingById(int id) {
		return rankingRepo.findById(id).get();
	}

	@Override
	public List<RankingView> getRankings() {
		return rankingRepo.findAll();
	}

}
