package racingcar.domain.game;

import static racingcar.utils.ExceptionConstants.EXCEEDS_MAX_ROUNDS;
import static racingcar.utils.ExceptionConstants.INVALID_ROUND_COUNT;
import static racingcar.view.InputValidator.validateUserInputIsNumber;

public class GameRound {
    private final int MAX_ROUNDS = 100;
    private final int MIN_ROUNDS = 1;
    private final int round;

    public GameRound(String roundInput) {
        this.round = parseAndValidateRound(roundInput);
    }

    public int getRound() {
        return round;
    }

    private int parseAndValidateRound(String roundInput) {
        validateUserInputIsNumber(roundInput);
        int parsedRound = Integer.parseInt(roundInput);
        validateRound(parsedRound);
        return parsedRound;
    }

    private void validateRound(int round) {
        if (round > MAX_ROUNDS) {
            throw new IllegalArgumentException(EXCEEDS_MAX_ROUNDS.getErrorMessage());
        }
        if (round < MIN_ROUNDS) {
            throw new IllegalArgumentException(INVALID_ROUND_COUNT.getErrorMessage());
        }
    }
}
