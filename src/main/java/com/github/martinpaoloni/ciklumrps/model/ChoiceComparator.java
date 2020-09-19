package com.github.martinpaoloni.ciklumrps.model;

import java.util.Comparator;

/**
 * Compares two {@link Choice}s.
 *
 * 1 = Player 1 beats Player 2.
 * 0 = Player 1 draws with Player 2.
 * -1 = Player 2 beats Player 1.
 */
public class ChoiceComparator implements Comparator<Choice> {
    @Override
    public int compare(Choice p1, Choice p2) {
        if (p1 == p2) {
            return 0;
        }
        return p1.beats(p2) ? 1 : -1;
    }
}
