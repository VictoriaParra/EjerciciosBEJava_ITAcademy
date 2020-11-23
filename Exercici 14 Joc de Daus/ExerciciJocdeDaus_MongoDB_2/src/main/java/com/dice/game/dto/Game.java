package com.dice.game.dto;

/**
 * @author Victoria Parra
 */

public class Game {

	// Atributos de entidad game

	private int dice1;
	private int dice2;
	private String gameResult;

	// CONSTRUCTORES

	/**
	 * Constructor vacio
	 */
	public Game() {

	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param dice1      valor del dado1
	 * @param dice2      valor del dado2
	 * @param gameResult resultado de la partida
	 */
	public Game(int dice1, int dice2, String gameResult) {

		this.dice1 = dice1;
		this.dice2 = dice2;
		this.gameResult = gameResult;
	}

	// GETTERS Y SETTERS

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

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Game [dice1=" + dice1 + ", dice2=" + dice2 + ", gameResult=" + gameResult + "]";
	}

	/**
	 * Método para calcular el porcentaje de exito del jugador
	 * 
	 * @param player jugador a quien hay que calcularle el successRate
	 * @return porcentaje de exito del jugador
	 */
	public int calculateSuccessRate(Player player) {

		// Instanciar e inicializar dos variables del tipo entero
		int totalWinGames = 0;
		int playedGames = 0;

		// Loopear las partidas del jugador
		for (Game g : player.getGame()) {
			/*
			 * Por cada partida incrementar la variable (partidas jugadas) y así obtener la
			 * cantidad de partidas jugadas por el jugador.
			 */
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
