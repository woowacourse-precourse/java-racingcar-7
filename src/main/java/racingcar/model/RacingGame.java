package racingcar.model;

import java.util.List;

public class RacingGame {
    private List<Car> racer;
    private int round;

    public RacingGame(List<Car> racer, int round) {
        this.racer = racer;
        this.round = round;
    }
}
