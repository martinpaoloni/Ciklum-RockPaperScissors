package com.github.martinpaoloni.ciklumrps.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a round of Rock-Paper-Scissors, by grouping both player's choices.
 */
public class Round implements Serializable {
    /**
     * Player one's choice.
     */
    private Choice player1Play;
    /**
     * Player two's choice.
     */
    private Choice player2Play;

    /**
     * Creates an instance of {@link Round}.
     *
     * @param player1Play Player one's choice.
     * @param player2Play Player two's choice.
     */
    public Round(Choice player1Play, Choice player2Play) {
        this.player1Play = player1Play;
        this.player2Play = player2Play;
    }

    /**
     * Gets player one's choice.
     *
     * @return Player one's choice.
     */
    public Choice getPlayer1Play() {
        return player1Play;
    }

    /**
     * Gets player two's choice.
     *
     * @return Player two's choice.
     */
    public Choice getPlayer2Play() {
        return player2Play;
    }

    /**
     * Gets the result of the {@link Round}, as described in {@link ChoiceComparator}.
     *
     * @return The result: 1 if player one won, 0 if it was a draw, and -1 if player two won.
     */
    public int getResult() {
        return new ChoiceComparator().compare(player1Play, player2Play);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return player1Play == round.player1Play &&
                player2Play == round.player2Play;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1Play, player2Play);
    }
}
