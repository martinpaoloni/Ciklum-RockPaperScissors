package com.github.martinpaoloni.ciklumrps.model;

/**
 * Key statistics of a group of {@link Round}s.
 */
public class Stats {

    /**
     * The number of rounds won by player one.
     */
    private long roundsWonByPlayer1;
    /**
     * The number of rounds that ended in a draw.
     */
    private long roundsDraw;
    /**
     * The number of rounds won by player two.
     */
    private long roundsWonByPlayer2;

    /**
     * Creates a blank {@link Stats} object.
     */
    public Stats() {
    }

    /**
     * Creates a blank {@link Stats} object.
     *
     * @param roundsWonByPlayer1 The number of rounds won by player one.
     * @param roundsDraw The number of rounds that ended in a draw.
     * @param roundsWonByPlayer2 The number of rounds won by player two.
     */
    public Stats(long roundsWonByPlayer1, long roundsDraw, long roundsWonByPlayer2) {
        this.roundsWonByPlayer1 = roundsWonByPlayer1;
        this.roundsDraw = roundsDraw;
        this.roundsWonByPlayer2 = roundsWonByPlayer2;
    }

    /**
     * Gets the number of rounds won by player one.
     *
     * @return The number of rounds.
     */
    public long getRoundsWonByPlayer1() {
        return roundsWonByPlayer1;
    }

    /**
     * Gets the number of rounds that ended in a draw.
     *
     * @return The number of rounds.
     */
    public long getRoundsDraw() {
        return roundsDraw;
    }

    /**
     * Gets the number of rounds won by player two.
     *
     * @return The number of rounds.
     */
    public long getRoundsWonByPlayer2() {
        return roundsWonByPlayer2;
    }

    /**
     * Gets the total number of rounds played.
     *
     * @return The number of rounds.
     */
    public long getRoundsPlayed() {
        return roundsWonByPlayer1 + roundsDraw + roundsWonByPlayer2;
    }

    /**
     * Counts the given {@link Round} in the statistics.
     *
     * @param round The {@link Round} to add to the sums.
     */
    public void countRound(Round round) {
        int result = round.getResult();
        if (result == 1) {
            roundsWonByPlayer1++;
        } else if (result == -1) {
            roundsWonByPlayer2++;
        } else {
            roundsDraw++;
        }
    }
}
