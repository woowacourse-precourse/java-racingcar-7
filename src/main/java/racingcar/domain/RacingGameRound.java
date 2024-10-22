package racingcar.domain;

import static racingcar.exception.constants.ErrorMessage.INVALID_NUMBER;

import racingcar.exception.RacingCarException;

public class RacingGameRound {

    private final Integer round;

    public RacingGameRound(final Integer round) {
        validate(round);

        this.round = round;
    }

    public Integer getRound() {
        return round;
    }

    private void validate(final Integer round) {
        if (round == null || round <= 0) {
            throw new RacingCarException(INVALID_NUMBER.getMessage());
        }
    }
}
