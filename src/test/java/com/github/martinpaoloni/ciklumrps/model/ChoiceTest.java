package com.github.martinpaoloni.ciklumrps.model;

import org.junit.jupiter.api.Test;

import static com.github.martinpaoloni.ciklumrps.model.Choice.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChoiceTest {

    @Test
    public void rockBeatsScissors() {
        assertTrue(ROCK.beats(SCISSORS));
    }

    @Test
    public void scissorsDoesNotBeatRock() {
        assertFalse(SCISSORS.beats(ROCK));
    }

    @Test
    public void rockDoesNotBeatItself() {
        assertFalse(ROCK.beats(ROCK));
    }

    @Test
    public void scissorsBeatPaper() {
        assertTrue(SCISSORS.beats(PAPER));
    }

    @Test
    public void paperDoesNotBeatRock() {
        assertFalse(PAPER.beats(SCISSORS));
    }

    @Test
    public void scissorsDoesNotBeatItself() {
        assertFalse(SCISSORS.beats(SCISSORS));
    }

    @Test
    public void paperBeatsRock() {
        assertTrue(PAPER.beats(ROCK));
    }

    @Test
    public void rockDoesNotBeatPaper() {
        assertFalse(ROCK.beats(PAPER));
    }

    @Test
    public void paperDoesNotBeatItself() {
        assertFalse(PAPER.beats(PAPER));
    }

}
