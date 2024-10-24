package racingcar.model;

public class Round {

    private static final int ROUND_DEFAULT = 0;
    private static final int ROUND_MIN_COUNT = 1;
    private static final int ROUND_MAX_COUNT = 15;

    private final int finalRound;
    private int currentRound;

    public Round(final int finalRound) {
        validate(finalRound);
        this.finalRound = finalRound;
        this.currentRound = ROUND_DEFAULT;
    }

    public boolean isOnGoing() {
        return currentRound < finalRound;
    }

    public void advance() {
        currentRound += 1;
    }

    private void validate(final int finalRound) {
        if (finalRound < ROUND_MIN_COUNT) {
            throw new IllegalArgumentException();
        }
        if (finalRound > ROUND_MAX_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}