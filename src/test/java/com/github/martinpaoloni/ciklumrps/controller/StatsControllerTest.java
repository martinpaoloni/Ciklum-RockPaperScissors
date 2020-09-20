package com.github.martinpaoloni.ciklumrps.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StatsControllerTest {

    @Test
    public void mappingTest() {
        assertNotNull(Thread.currentThread().getContextClassLoader().getResource("templates/" + new StatsController().stats() + ".html"));
    }
}
