package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final List<Car> racingCars;
    private final int round;

    public RacingGame(List<Car> cars, int round) {
        this.racingCars = cars;
        this.round = round;
    }
}
