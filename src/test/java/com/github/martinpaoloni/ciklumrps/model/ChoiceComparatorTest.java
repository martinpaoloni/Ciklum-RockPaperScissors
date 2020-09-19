package com.github.martinpaoloni.ciklumrps.model;

import org.junit.jupiter.api.Test;

import static com.github.martinpaoloni.ciklumrps.model.Choice.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChoiceComparatorTest {

    private ChoiceComparator choiceComparator = new ChoiceComparator();

    @Test
    public void rockBeatsScissors() {
        assertEquals(1, choiceComparator.compare(ROCK, SCISSORS));
    }

    @Test
    public void scissorsDoesNotBeatRock() {
        assertEquals(-1, choiceComparator.compare(SCISSORS, ROCK));
    }

    @Test
    public void rockDraw() {
        assertEquals(0, choiceComparator.compare(ROCK, ROCK));
    }

    @Test
    public void scissorsBeatPaper() {
        assertEquals(1, choiceComparator.compare(SCISSORS, PAPER));
    }

    @Test
    public void paperDoesNotBeatRock() {
        assertEquals(-1, choiceComparator.compare(PAPER, SCISSORS));
    }

    @Test
    public void scissorsDraw() {
        assertEquals(0, choiceComparator.compare(SCISSORS, SCISSORS));
    }

    @Test
    public void paperBeatsRock() {
        assertEquals(1, choiceComparator.compare(PAPER, ROCK));
    }

    @Test
    public void rockDoesNotBeatPaper() {
        assertEquals(-1, choiceComparator.compare(ROCK, PAPER));
    }

    @Test
    public void paperDraw() {
        assertEquals(0, choiceComparator.compare(PAPER, PAPER));
    }

}
