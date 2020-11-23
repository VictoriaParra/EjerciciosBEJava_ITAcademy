package com.dice.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dice.game.dto.Games;

/**
 * @author Victoria Parra
 */

public interface IGamesDAO extends JpaRepository<Games, Integer> {

}
