package com.dice.game.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Victoria Parra
 */

@Entity // especifica que la clase es una entidad y está asignada a una tabla de bbdd
@Table(name = "games")
public class Game {

	// Atributos de entidad games
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column(name = "dice1") // no hace falta si se llama igual
	private int dice1;
	@Column(name = "dice2") // no hace falta si se llama igual
	private int dice2;
	@Column(name = "game_result") // no hace falta si se llama igual
	private String gameResult;

	@ManyToOne // se usa para especificar una relación de base de datos de muchos a uno.
	@JoinColumn(name = "players_id") // es como un inner join. Se especifica porque columna se unen(fk)
	Player player;

	// CONSTRUCTORES

	/**
	 * Constructor por defecto/vacio
	 */
	public Game() {
	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param id         id de la partida
	 * @param dice1      valor del dado1
	 * @param dice2      valor del dado 2
	 * @param gameResult resultado de la partida
	 * @param player     jugador de la partida
	 */
	public Game(int id, int dice1, int dice2, String gameResult, Player player) {

		this.id = id;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.gameResult = gameResult;
		this.player = player;
	}

	// GETTERS Y SETTERS

	/**
	 * @return id de la partida
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id to set id de la partida
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return valor del dado1
	 */
	public int getDice1() {
		return dice1;
	}

	/**
	 * @param dice1 to set valor dado1
	 */
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	/**
	 * @return valor del dado2
	 */
	public int getDice2() {
		return dice2;
	}

	/**
	 * @param dice2 to set valor dado2
	 */
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	/**
	 * @return resultado de la partida(win-lose)
	 */
	public String getGameResult() {
		return gameResult;
	}

	/**
	 * @param gameResult to set resultado de la partida
	 */
	public void setGameResult(String gameResult) {
		this.gameResult = gameResult;
	}

	/**
	 * @return jugador
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player to set jugador
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Game [id=" + id + ", dice1=" + dice1 + ", dice2=" + dice2 + ", gameResult=" + gameResult + ", player="
				+ player + "]";
	}

	/**
	 * Método para calcular el porcentaje de exito del jugador
	 * 
	 * @return porcentaje de exito del jugador
	 */
	public int calculateSuccessRate() {

		// Instanciar e inicializar dos variables del tipo entero
		int totalWinGames = 0;
		int playedGames = 0;

		// Loopear las partidas del jugador
		for (Game g : player.getGame()) {

			// Por cada partida incrementar la variable (partidas jugadas) y asi saber cual
			// es la cantidad de partidas jugadas por el jugador.
			playedGames++;

			// Incrementar la variable partidas ganadas si el resultado de la partida es
			// igual a "win".
			if (g.getGameResult().equalsIgnoreCase("win")) {
				totalWinGames++;
			}
		}

		// Validar que el divisor no sea 0
		if (playedGames == 0) {
			return 0;
		} else {
			// Calcular porcentaje
			int calculatedSuccessRate = (totalWinGames * 100) / playedGames;

			// Devolver porcentaje de exito calculado
			return calculatedSuccessRate;
		}
	}

}
