package com.github.martinpaoloni.ciklumrps.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IndexControllerTest {

    @Test
    public void mappingTest() {
        assertNotNull(Thread.currentThread().getContextClassLoader().getResource("templates/" + new IndexController().index() + ".html"));
    }
}
