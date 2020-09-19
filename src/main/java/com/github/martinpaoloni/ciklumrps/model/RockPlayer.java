package com.github.martinpaoloni.ciklumrps.model;

import static com.github.martinpaoloni.ciklumrps.model.Choice.ROCK;

/**
 * A Rock-Paper-Scissors player that is super boring and always picks ROCK.
 */
public class RockPlayer extends SingleChoicePlayer {

    /**
     * Creates a {@link RockPlayer}.
     */
    public RockPlayer() {
        super("Rock player", ROCK);
    }
}
