package com.github.martinpaoloni.ciklumrps.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPlayerTest {

    @Test
    public void playerName() {
        assertEquals("Random player", new RandomPlayer().getName());
    }

    @Test
    public void playsReturnType() {
        Player player = new RandomPlayer();
        assertEquals(Choice.class, player.play().getClass());
    }

    @Test
    public void playsAllThreeRandomly() {
        Player player = new RandomPlayer();
        Boolean[] allPlayed = new Boolean[]{FALSE, FALSE, FALSE};
        do {
            allPlayed[player.play().ordinal()] = TRUE;
        } while (notAllTested(allPlayed));
    }

    private boolean notAllTested(Boolean[] array) {
        return Arrays.stream(array).anyMatch(entry -> entry == FALSE);
    }
}
