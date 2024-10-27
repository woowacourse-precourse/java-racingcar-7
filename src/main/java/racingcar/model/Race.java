package racingcar.model;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final Integer round;

    public Race(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Integer getRound() {
        return round;
    }
}
