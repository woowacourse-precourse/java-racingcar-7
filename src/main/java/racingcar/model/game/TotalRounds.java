package racingcar.model.game;

import static racingcar.model.ExceptionMessages.TotalRounds.TOTAL_ROUNDS_ABOVE_MAXIMUM;
import static racingcar.model.ExceptionMessages.TotalRounds.TOTAL_ROUNDS_BELOW_MINIMUM;

public class TotalRounds {

    private static final int MAX_TOTAL_ROUNDS = 10;
    private static final int MIN_TOTAL_ROUNDS = 1;
    private final int roundCount;

    public TotalRounds(int roundCount) {
        validateRoundsInRange(roundCount);

        this.roundCount = roundCount;
    }

    private void validateRoundsInRange(int totalRounds) {
        if (totalRounds < MIN_TOTAL_ROUNDS) {
            throw new IllegalArgumentException(TOTAL_ROUNDS_BELOW_MINIMUM);
        }

        if (totalRounds > MAX_TOTAL_ROUNDS) {
            throw new IllegalArgumentException(TOTAL_ROUNDS_ABOVE_MAXIMUM);
        }
    }

    public boolean hasMoreRoundsThan(int currentRound) {
        return roundCount > currentRound;
    }
}
