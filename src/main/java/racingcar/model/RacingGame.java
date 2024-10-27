package racingcar.model;

import java.util.List;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int attempts;

    public RacingGame(List<RacingCar> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }
}
