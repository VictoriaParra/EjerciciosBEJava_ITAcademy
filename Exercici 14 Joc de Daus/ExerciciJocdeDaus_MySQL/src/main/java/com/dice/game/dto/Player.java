package com.dice.game.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Victoria Parra
 */

@Entity // especifica que la clase es una entidad y está asignada a una tabla de bbdd
@Table(name = "players")
public class Player {

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
	@Column(name = "success_rate") // no hace falta si se llama igual
	private int successRate;

	// @OneToMany: se utiliza para especificar una relación de bd de uno a muchos.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
	private List<Game> game;

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
	public Player(int id, String name, Date registration_date, int successRate, List<Game> game) {

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
