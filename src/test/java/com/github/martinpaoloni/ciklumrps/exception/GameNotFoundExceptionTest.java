package com.github.martinpaoloni.ciklumrps.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameNotFoundExceptionTest {

    @Test
    public void message() {
        Exception exception = new GameNotFoundException(1);
        assertEquals("Could not found Game with id = 1", exception.getMessage());
    }
}
