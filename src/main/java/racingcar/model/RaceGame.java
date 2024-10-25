package racingcar.model;

import java.util.List;

public class RaceGame {
    private final List<Car> cars;
    private final int attempts;

    public RaceGame(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }


}
