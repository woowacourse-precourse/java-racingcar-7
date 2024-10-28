package racingcar.model;

import java.util.List;

public class RacingGame {
    private List<Car> racer;
    private int round;

    public RacingGame(List<Car> racer, int round) {
        validateRound(round);

        this.racer = racer;
        this.round = round;
    }

    private void validateRound(int round) {
        if (round <= 0)
            throw new IllegalArgumentException();
    }
}
