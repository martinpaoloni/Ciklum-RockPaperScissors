package com.github.martinpaoloni.ciklumrps.model;

import java.io.Serializable;

/**
 * An abstract Rock-Paper-Scissors player.
 */
public abstract class Player implements Serializable {

    /**
     * The player's name.
     */
    private final String name;

    /**
     * Creates a {@link Player} instance.
     *
     * @param name The player's name.
     */
    protected Player(String name) {
        this.name = name;
    }

    /**
     * Plays a round.
     *
     * @return A value from {@link Choice}.
     */
    public abstract Choice play();

    /**
     * Gets the player's name.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

}
