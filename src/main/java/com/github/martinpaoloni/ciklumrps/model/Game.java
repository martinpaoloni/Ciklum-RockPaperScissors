package com.github.martinpaoloni.ciklumrps.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a {@link Game} of Rock-Paper-Scissors, which is formed by two {@link Player}s and a number of {@link Round}s.
 */
public class Game implements Serializable {

    /**
     * The player 1.
     */
    private final Player player1;
    /**
     * The player 2.
     */
    private final Player player2;
    /**
     * The rounds played.
     */
    private List<Round> rounds;

    /**
     * The ID of the game.
     */
    private final int id;

    /**
     * Creates a new {@link Game} instance.
     *
     * @param player1 The player 1.
     * @param player2 The player 2.
     */
    public Game(int id, Player player1, Player player2) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        rounds = new LinkedList<>();
    }

    /**
     * Plays and records a round between players 1 and 2.
     *
     * @return The played {@link Round}.
     */
    public Round playRound() {
        Round round = new Round(player1.play(), player2.play());
        rounds.add(round);
        return round;
    }

    /**
     * Calculates the number of rounds that were played.
     *
     * @return The number of rounds.
     */
    public int numberOfRoundsPlayed() {
        return rounds.size();
    }

    /**
     * Clears the list of rounds, making this essentially a new game.
     *
     * @return The current {@link Game} instance.
     */
    public Game restartGame() {
        rounds = new LinkedList<>();
        return this;
    }

    public int getId() {
        return id;
    }

    /**
     * Gets the {@linkl Player} 1 instance.
     *
     * @return The {@linkl Player} 1 instance.
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Gets the {@linkl Player} 2 instance.
     *
     * @return The {@linkl Player} 2instance.
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Gets the complete list of {@link Round}s played.
     *
     * @return The list of {@link Round}s played.
     */
    public List<Round> getRounds() {
        return rounds;
    }

    /**
     * Returns a summary of all the played {@link Round}s.
     *
     * @return a {@link Stats} object containing the summary.
     */
    public Stats getSummary() {
        return new Stats(roundsByResult(1), roundsByResult(0), roundsByResult(-1));
    }

    /**
     * Calculates the number of rounds that obtained a given result, as described by {@link ChoiceComparator}.
     *
     * @param result The result to count.
     * @return The number of rounds.
     */
    private long roundsByResult(int result) {
        return rounds.stream().filter(r -> r.getResult() == result).count();
    }
}
