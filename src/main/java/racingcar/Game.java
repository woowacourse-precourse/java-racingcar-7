package racingcar;

import java.util.List;

public class Game {

    private final Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public List<Integer> race() {
        return cars.go();
    }
}
