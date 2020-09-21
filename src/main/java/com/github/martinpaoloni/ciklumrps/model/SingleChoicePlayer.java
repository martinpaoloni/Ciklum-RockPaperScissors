package com.github.martinpaoloni.ciklumrps.model;

/**
 * An abstract Rock-Paper-Scissors player that always return the same choice.
 */
public class SingleChoicePlayer extends Player {

    /**
     * The choice that this player will always return.
     */
    private final Choice choice;

    /**
     * Creates a {@link SingleChoicePlayer}.
     *
     * @param name   The player's name.
     * @param choice The choice that the player will always return.
     */
    public SingleChoicePlayer(String name, Choice choice) {
        super(name);
        this.choice = choice;
    }

    @Override
    public Choice play() {
        return choice;
    }
}
