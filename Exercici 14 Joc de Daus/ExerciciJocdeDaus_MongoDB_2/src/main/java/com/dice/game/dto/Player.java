package com.dice.game.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Victoria Parra
 */

@Document(collection = "Player") // Document es el equivalente a Entity en JPA
public class Player {

	// Atributos de entidad player
	@Id
	private String id;
	private String name;
	private Date registration_date = new Date();
	private int successRate;

	private List<Game> game = new ArrayList<Game>();

	// CONSTRUCTORES

	/**
	 * Constructor vacio
	 */
	public Player() {

	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param id                del jugador
	 * @param name              nombre del jugador
	 * @param registration_date fecha de registro
	 * @param successRate       porcentaje de exito
	 * @param game              lista de partidas
	 */
	public Player(String id, String name, Date registration_date, int successRate, List<Game> game) {
		this.id = id;
		this.name = name;
		this.registration_date = registration_date;
		this.successRate = successRate;
		this.game = game;
	}

	// GETTERS Y SETTERS

	/**
	 * @return id del jugador
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id to set id del jugador
	 */
	public void setId(String id) {
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
	public Date getRegistration_date() {
		return registration_date;
	}

	/**
	 * @param registrationDate to set la fecha de registro
	 */
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	/**
	 * @return porcentaje de exito
	 */
	public int getSuccessRate() {
		return successRate;
	}

	/**
	 * @param successRate to set porcentaje de exito
	 */
	public void setSuccessRate(int successRate) {
		this.successRate = successRate;
	}

	/**
	 * JsonIgnore: de este modo al hacer un GET de jugador me trae solo los datos
	 * del mismo y no las partidas que posee.
	 * 
	 * @return lista de partidas
	 */
	@JsonIgnore
	public List<Game> getGame() {
		return game;
	}

	/**
	 * @param game to set la lista de partidas
	 */
	public void setGame(List<Game> game) {
		this.game = game;
	}

	// Método impresion de datos por consola
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", registration_date=" + registration_date + ", successRate="
				+ successRate + ", game=" + game + "]";
	}

}
