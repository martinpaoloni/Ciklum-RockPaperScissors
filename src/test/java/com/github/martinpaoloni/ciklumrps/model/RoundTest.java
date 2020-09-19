package com.github.martinpaoloni.ciklumrps.model;

import org.junit.jupiter.api.Test;

import static com.github.martinpaoloni.ciklumrps.model.Choice.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RoundTest {

    @Test
    public void rockBeatsScissors() {
        assertEquals(1, new Round(ROCK, SCISSORS).getResult());
    }

    @Test
    public void scissorsDoesNotBeatRock() {
        assertEquals(-1, new Round(SCISSORS, ROCK).getResult());
    }

    @Test
    public void rockDraw() {
        assertEquals(0, new Round(ROCK, ROCK).getResult());
    }

    @Test
    public void scissorsBeatPaper() {
        assertEquals(1, new Round(SCISSORS, PAPER).getResult());
    }

    @Test
    public void paperDoesNotBeatRock() {
        assertEquals(-1, new Round(PAPER, SCISSORS).getResult());
    }

    @Test
    public void scissorsDraw() {
        assertEquals(0, new Round(SCISSORS, SCISSORS).getResult());
    }

    @Test
    public void paperBeatsRock() {
        assertEquals(1, new Round(PAPER, ROCK).getResult());
    }

    @Test
    public void rockDoesNotBeatPaper() {
        assertEquals(-1, new Round(ROCK, PAPER).getResult());
    }

    @Test
    public void paperDraw() {
        assertEquals(0, new Round(PAPER, PAPER).getResult());
    }

    @Test
    public void equalsSameObject() {
        Round round = new Round(ROCK, SCISSORS);
        assertEquals(round, round);
    }

    @Test
    public void equalsEquivalentObject() {
        Round round1 = new Round(ROCK, SCISSORS);
        Round round2 = new Round(ROCK, SCISSORS);
        assertEquals(round2, round1);
    }

    @Test
    public void equalsDifferentType() {
        Round round = new Round(ROCK, SCISSORS);
        assertNotEquals("", round);
    }

    @Test
    public void equalsDifferentPlayerOnePlay() {
        Round round1 = new Round(ROCK, SCISSORS);
        Round round2 = new Round(PAPER, SCISSORS);
        assertNotEquals(round2, round1);
    }

    @Test
    public void equalsDifferentPlayerTwoPlay() {
        Round round1 = new Round(ROCK, SCISSORS);
        Round round2 = new Round(ROCK, PAPER);
        assertNotEquals(round2, round1);
    }


}
