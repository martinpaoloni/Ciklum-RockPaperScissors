package com.github.martinpaoloni.ciklumrps.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsTest {

    @Test
    public void basicTest() {
        Stats stats = new Stats(1, 17, 2);
        assertEquals(1, stats.getRoundsWonByPlayer1());
        assertEquals(2, stats.getRoundsWonByPlayer2());
        assertEquals(17, stats.getRoundsDraw());
        assertEquals(20, stats.getRoundsPlayed());
    }

    @Test
    public void countRound() {
        Stats stats = new Stats();
        assertEquals(0, stats.getRoundsWonByPlayer1());
        assertEquals(0, stats.getRoundsWonByPlayer2());
        assertEquals(0, stats.getRoundsDraw());
        assertEquals(0, stats.getRoundsPlayed());

        stats.countRound(new Round(Choice.ROCK, Choice.PAPER));
        assertEquals(0, stats.getRoundsWonByPlayer1());
        assertEquals(1, stats.getRoundsWonByPlayer2());
        assertEquals(0, stats.getRoundsDraw());
        assertEquals(1, stats.getRoundsPlayed());

        stats.countRound(new Round(Choice.PAPER, Choice.ROCK));
        assertEquals(1, stats.getRoundsWonByPlayer1());
        assertEquals(1, stats.getRoundsWonByPlayer2());
        assertEquals(0, stats.getRoundsDraw());
        assertEquals(2, stats.getRoundsPlayed());

        stats.countRound(new Round(Choice.SCISSORS, Choice.SCISSORS));
        assertEquals(1, stats.getRoundsWonByPlayer1());
        assertEquals(1, stats.getRoundsWonByPlayer2());
        assertEquals(1, stats.getRoundsDraw());
        assertEquals(3, stats.getRoundsPlayed());
    }
}
