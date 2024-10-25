package racingcar.model;

import static racingcar.constants.ErrorMessage.INVALID_NOT_NUMBER;
import static racingcar.constants.ErrorMessage.INVALID_NOT_POSTIVE_NUMBER;
import static racingcar.constants.Symbol.ZERO;

public class GameRound {
    private final Integer round;

    public GameRound(String round) {
        this.round = validateRound(round);
    }

    private Integer validateRound(String round) {
        try {
            Integer parsedRound = Integer.parseInt(round);
            validatePositive(parsedRound);
            return parsedRound;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NOT_NUMBER);
        }
    }

    private void validatePositive(Integer round) {
        if (isNotPositive(round)) {
            throw new IllegalArgumentException(INVALID_NOT_POSTIVE_NUMBER);
        }
    }

    private boolean isNotPositive(Integer round) {
        return round < ZERO;
    }

    public Integer getRound() {
        return round;
    }
}
