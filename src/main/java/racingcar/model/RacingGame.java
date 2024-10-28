package racingcar.model;

import racingcar.exception.RacingGameException;

public class RacingGame {
    private static final Integer MINIMUM_ROUND = 1;
    private final RacingTrack racingTrack;
    private final Integer round;

    public RacingGame(Integer round) {
        this.racingTrack = new RacingTrack();
        validateRound(round);
        this.round = round;
    }

    private void validateRound(Integer round) {
        if (round < MINIMUM_ROUND) {
            throw new IllegalArgumentException(RacingGameException.ROUND_IS_LESS_THAN_ONE.getMessage());
        }
    }
}
