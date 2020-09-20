package com.github.martinpaoloni.ciklumrps.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    private static final int NUMBER_OF_ROUNDS = 10;

    @Test
    public void beanTest() {
        int id = 10;
        Player playerOne = new RandomPlayer();
        Player playerTwo = new RockPlayer();
        Game game = new Game(id, playerOne, playerTwo);
        assertEquals(id, game.getId());
        assertEquals(playerOne, game.getPlayer1());
        assertEquals(playerTwo, game.getPlayer2());
        assertEquals(0, game.getRounds().size());
        game.playRound();
        assertEquals(1, game.getRounds().size());
    }

    @Test
    public void playRound() {
        Round roundPlayed = new Game(0, new RandomPlayer(), new RockPlayer()).playRound();
        Round otherRound = new Round(roundPlayed.getPlayer1Play(), roundPlayed.getPlayer2Play());
        assertEquals(otherRound, roundPlayed);
    }

    @Test
    public void numberOfRounds() {
        Game game = new Game(0, new RandomPlayer(), new RockPlayer());
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            game.playRound();
        }
        assertEquals(NUMBER_OF_ROUNDS, game.numberOfRoundsPlayed());
    }

    @Test
    public void zeroNumberOfRounds() {
        Game game = new Game(0, new RandomPlayer(), new RockPlayer());
        assertEquals(0, game.numberOfRoundsPlayed());
    }

    @Test
    public void restartGameRoundsPlayed() {
        Game game = new Game(0, new RandomPlayer(), new RockPlayer());
        game.playRound();
        game.playRound();
        assertEquals(2, game.numberOfRoundsPlayed());
        game.restartGame();
        assertEquals(0, game.numberOfRoundsPlayed());
        game.playRound();
        assertEquals(1, game.numberOfRoundsPlayed());
    }

    @Test
    public void summary() {
        Game game = new Game(0, new RandomPlayer(), new RockPlayer());
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            game.playRound();
        }
        Stats summary = game.getSummary();
        assertEquals(NUMBER_OF_ROUNDS, summary.getRoundsPlayed());
        assertTrue(NUMBER_OF_ROUNDS >= summary.getRoundsWonByPlayer1());
        assertTrue(NUMBER_OF_ROUNDS >= summary.getRoundsDraw());
        assertTrue(NUMBER_OF_ROUNDS >= summary.getRoundsWonByPlayer2());
        game.restartGame();
        summary = game.getSummary();
        assertEquals(0, summary.getRoundsPlayed());
        assertEquals(0, summary.getRoundsWonByPlayer1());
        assertEquals(0, summary.getRoundsDraw());
        assertEquals(0, summary.getRoundsWonByPlayer2());

    }

}
