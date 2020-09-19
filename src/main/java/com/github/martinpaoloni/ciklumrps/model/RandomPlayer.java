package com.github.martinpaoloni.ciklumrps.model;

/**
 * A Rock-Paper-Scissors player that does pseudo-random choices.
 */
public class RandomPlayer extends Player {

    /**
     * Creates a {@link RandomPlayer}.
     */
    public RandomPlayer() {
        super("Random player");
    }

    @Override
    public Choice play() {
        return Choice.randomChoice();
    }
}
