package com.github.martinpaoloni.ciklumrps.model;

import java.util.Random;

/**
 * Represents the available options ina Rock-Paper-Scissors game.
 */
public enum Choice implements Comparable<Choice> {
    ROCK,
    SCISSORS,
    PAPER;

    static {
        ROCK.beats = SCISSORS;
        SCISSORS.beats = PAPER;
        PAPER.beats = ROCK;
    }

    /**
     * The values from the enum.
     */
    private static final Choice[] VALUES = values();
    /**
     * The number of available options.
     */
    private static final int SIZE = VALUES.length;
    /**
     * Random number generator.
     */
    private static final Random RANDOM = new Random();
    /**
     * The {@link Choice}  that is beaten by the current one.
     */
    private Choice beats;

    /**
     * Returns true if the current options beats the given one.
     *
     * @param other The other option.
     * @return A boolean. True if the current option beats the given one, false if it does not.
     */
    boolean beats(Choice other) {
        return beats == other;
    }

    /**
     * Returns a pseudo-random choice {@link Choice}.
     *
     * @return A {@link Choice} value.
     */
    public static Choice randomChoice() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

}
