package racingcar.model;

import java.util.List;
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

    public void addCar(List<String> names) {
        racingTrack.addCar(names);
    }

    private void validateRound(Integer round) {
        if (round < MINIMUM_ROUND) {
            throw new IllegalArgumentException(RacingGameException.ROUND_IS_LESS_THAN_ONE.getMessage());
        }
    }
}
