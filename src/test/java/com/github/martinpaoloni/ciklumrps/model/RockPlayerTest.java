package com.github.martinpaoloni.ciklumrps.model;

import org.junit.jupiter.api.Test;

import static com.github.martinpaoloni.ciklumrps.model.Choice.ROCK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockPlayerTest {

    @Test
    public void playerName() {
        assertEquals("Rock player", new RockPlayer().getName());
    }

    @Test
    public void alwaysPlaysRock() {
        assertEquals(ROCK, new RockPlayer().play());
    }
}
