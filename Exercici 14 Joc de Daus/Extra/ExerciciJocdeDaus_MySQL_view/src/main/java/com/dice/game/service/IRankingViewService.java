package com.dice.game.service;

import java.util.List;

import com.dice.game.dto.RankingView;

/**
 * @author Victoria Parra
 */

public interface IRankingViewService {

	// Métodos que implementará la clase service
	
	public RankingView findRankingById(int id); // READ - leer datos de un ranking según id

	public List<RankingView> getRankings(); // READ- Listar rankings

}
