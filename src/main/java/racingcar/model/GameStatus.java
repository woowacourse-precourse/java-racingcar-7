package racingcar.model;

import racingcar.constant.ErrorMessage;

public class GameStatus {
    private static final int ATTEMPTS_BASE = 0;
    private static final int MINIMUM_TOTAL_ATTEMPTS = 1;

    private final int totalAttempts;
    private int currentAttempts;

    private GameStatus(final int totalAttempts) {
        validateTotalAttemptsIsPositiveNumber(totalAttempts);

        this.totalAttempts = totalAttempts;
        this.currentAttempts = ATTEMPTS_BASE;
    }

    public static GameStatus from(final int totalAttempts) {
        return new GameStatus(totalAttempts);
    }

    private void validateTotalAttemptsIsPositiveNumber(final int totalAttempts) {
        if (totalAttempts < MINIMUM_TOTAL_ATTEMPTS) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPTS_SIGN_POSITIVE.getMessage());
        }
    }

    public void attempt() {
        ++currentAttempts;
    }
}
