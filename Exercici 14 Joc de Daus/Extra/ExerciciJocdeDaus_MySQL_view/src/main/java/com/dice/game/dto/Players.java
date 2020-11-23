package com.dice.game.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Victoria Parra
 */

@Entity
@Table(name = "players")
public class Players {

	// Atributos de entidad players
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name") // no hace falta si se llama igual
	private String name;
	// la columna registration_date lo completa directamente la bd
	@Column(insertable = false, name = "registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registration_date;

	// @OneToMany: se utiliza para especificar una relación de bd de uno a muchos.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
	private List<Games> game;

	/*
	 * @OneToOne: se utiliza para especificar una relación de bd de uno a uno.
	 * 
	 * @PrimaryKeyJoinColumn: especifica que la pk es utilizada como fk para unir la
	 * otra tabla. La union es atraves de la pk.
	 */
	@OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private RankingView ranking;

	// CONSTRUCTORES

	/**
	 * Constructor por defecto/vacio
	 */
	public Players() {

	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param id                id del jugador
	 * @param name              nombre del jugador
	 * @param registration_date fecha de registro
	 * @param game              lista de partidas del jugador
	 * @param ranking           porcentaje de exito
	 */
	public Players(int id, String name, Date registration_date, List<Games> game, RankingView ranking) {
		this.id = id;
		this.name = name;
		this.registration_date = registration_date;
		this.game = game;
		this.ranking = ranking;
	}

	// GETTERS Y SETTERS

	/**
	 * @return id del jugador
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id to set id del jugador
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return nombre del jugador
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name to set nombre del jugador
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return la fecha de registro
	 */
	public Date getRegistrationDate() {
		return registration_date;
	}

	/**
	 * @param registrationDate to set la fecha de registro
	 */
	public void setRegistrationDate(Date registration_date) {
		this.registration_date = registration_date;
	}

	/**
	 * JsonIgnore: de este modo al hacer un GET de jugador me trae solo los datos
	 * del mismo y no las partidas que posee.
	 * 
	 * @return lista de partidas
	 */
	@JsonIgnore
	public List<Games> getGame() {
		return game;
	}

	/**
	 * @param game to set la lista de partidas
	 */
	public void setGame(List<Games> game) {
		this.game = game;
	}

	/**
	 * JsonIgnoreProperties: va a ignorar las columnas marcadas, es decir, vamos a
	 * traernos solo la columna de successRate de la tabla ranking.
	 * 
	 * @return ranking (solo successRate)
	 */
	@JsonIgnoreProperties({ "id", "won_games", "played_games", "players_id" })
	public RankingView getRanking() {
		return ranking;
	}

	/**
	 * @param ranking to set ranking
	 */
	public void setRanking(RankingView ranking) {
		this.ranking = ranking;
	}

	// Método impresion de datos por consola
	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", registration_date=" + registration_date + ", game=" + game
				+ "]";
	}

}
