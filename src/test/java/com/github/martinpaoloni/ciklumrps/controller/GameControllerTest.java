package com.github.martinpaoloni.ciklumrps.controller;

import com.github.martinpaoloni.ciklumrps.exception.GameNotFoundException;
import com.github.martinpaoloni.ciklumrps.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

    private GameController controller;

    @BeforeEach
    public void before() {
        controller = new GameController();
    }
    @Test
    public void listGamesEmpty() {

        assertEquals(0, controller.listGames().size());
    }

    @Test
    public void listGamesOne() {
        controller.startGame();
        assertEquals(1, controller.listGames().size());
    }

    @Test
    public void emptyStats() {
        Stats stats = controller.stats();
        assertEquals(0, stats.getRoundsPlayed());
        assertEquals(0, stats.getRoundsWonByPlayer1());
        assertEquals(0, stats.getRoundsWonByPlayer2());
        assertEquals(0, stats.getRoundsDraw());
    }

    @Test
    public void nonEmptyStats() {
        Game game = controller.startGame();
        controller.playRound(game.getId());
        Stats stats = controller.stats();
        assertEquals(1, stats.getRoundsPlayed());
    }

    @Test
    public void nonExistingGame() {
        assertThrows(GameNotFoundException.class, () -> {
            controller.game(0);
        });
    }

    @Test
    public void eistingGame() {
        Game game = controller.startGame();
        assertEquals(game, controller.game(game.getId()));
    }

    @Test
    public void startGame() {
        Game game = controller.startGame();
        Stats stats = game.getSummary();
        assertEquals(1, game.getId());
        assertTrue(game.getPlayer1() instanceof RandomPlayer);
        assertTrue(game.getPlayer2() instanceof RockPlayer);
        assertEquals(0, stats.getRoundsPlayed());
        assertEquals(0, stats.getRoundsWonByPlayer1());
        assertEquals(0, stats.getRoundsWonByPlayer2());
        assertEquals(0, stats.getRoundsDraw());
    }

    @Test
    public void playRound() {
        Game game = controller.startGame();
        Round round = controller.playRound(game.getId());
        assertEquals(Choice.ROCK, round.getPlayer2Play());
        assertNotNull(round.getPlayer1Play());
    }

    @Test
    public void deleteRounds() {
        Game game = controller.startGame();
        assertEquals(0, controller.game(game.getId()).getSummary().getRoundsPlayed());
        controller.playRound(game.getId());
        assertEquals(1, controller.game(game.getId()).getSummary().getRoundsPlayed());
        controller.deleteRounds(game.getId());
        assertEquals(0, controller.game(game.getId()).getSummary().getRoundsPlayed());
    }

}
