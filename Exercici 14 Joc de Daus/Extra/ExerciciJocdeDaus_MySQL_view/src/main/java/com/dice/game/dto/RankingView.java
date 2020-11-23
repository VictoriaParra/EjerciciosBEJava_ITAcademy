package com.dice.game.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Victoria Parra
 */

@Entity
@Table(name = "ranking_view")
public class RankingView {

	// Atributos de entidad players
	@Id
	@Column(name = "players_id")
	private int id;
	@Column(name = "won_games") // no hace falta si se llama igual
	private int won_games;
	@Column(name = "played_games") // no hace falta si se llama igual
	private int played_games;
	@Column(name = "success_rate") // no hace falta si se llama igual
	private int successRate;

	@OneToOne // Se utiliza para especificar una relación de bd de uno a uno.
	@MapsId // Puede usarse para indicar que comparten la misma pk, comparten el mismo id
	@JoinColumn(name = "players_id") // es como un inner join. Se especifica porque columna se unen(fk)
	private Players player;

	// CONSTRUCTORES

	/**
	 * Constructor por default/vacio
	 */
	public RankingView() {

	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param id           id del ranking
	 * @param won_games    valor partidas ganadas
	 * @param played_games valor partidas jugadas
	 * @param success_rate valor porcentaje de exito
	 * @param player       jugador
	 */
	public RankingView(int id, int won_games, int played_games, int success_rate, Players player) {
		this.id = id;
		this.won_games = won_games;
		this.played_games = played_games;
		this.successRate = success_rate;
		this.player = player;
	}

	// GETTERS Y SETTERS

	/**
	 * @return id del ranking
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id to set id del ranking
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return partidas ganadas
	 */
	public int getWon_games() {
		return won_games;
	}

	/**
	 * @param won_games to set partidas ganadas
	 */
	public void setWon_games(int won_games) {
		this.won_games = won_games;
	}

	/**
	 * @return partidas jugadas
	 */
	public int getPlayed_games() {
		return played_games;
	}

	/**
	 * @param played_games to set partidas jugadas
	 */
	public void setPlayed_games(int played_games) {
		this.played_games = played_games;
	}

	/**
	 * @return porcentaje de exito
	 */
	public int getSuccess_rate() {
		return successRate;
	}

	/**
	 * @param success_rate to set porcentaje de exito
	 */
	public void setSuccess_rate(int success_rate) {
		this.successRate = success_rate;

	}

	/**
	 * JsonIgnore: de este modo al hacer un GET de ranking trae solo los datos del
	 * mismo y no los datos del jugador que posee ese ranking.
	 * 
	 * @return jugador
	 */
	@JsonIgnore
	public Players getPlayer() {
		return player;
	}

	/**
	 * @param player to set jugador
	 */
	public void setPlayer(Players player) {
		this.player = player;
	}

	// Método impresion de datos por consola
	@Override
	public String toString() {
		return "Ranking_view [id=" + id + ", won_games=" + won_games + ", played_games=" + played_games
				+ ", success_rate=" + successRate + ", player=" + player + "]";
	}

}
