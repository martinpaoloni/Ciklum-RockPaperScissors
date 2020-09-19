package com.github.martinpaoloni.ciklumrps.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdEntityTest {

    private static final String ID_VALUE = "Ciklum";

    @Test
    public void pojoTest() {
        IdEntity id = new IdEntity();
        id.setId(ID_VALUE);
        assertEquals(ID_VALUE, id.getId());
    }
}
