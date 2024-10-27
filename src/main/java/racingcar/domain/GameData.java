package racingcar.domain;

import java.util.List;

public class GameData {
    private final List<Car> cars;
    private final int attempts;

    public GameData(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }

}
