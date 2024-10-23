package racingcar;

import java.util.List;

public class Race {
    private final Integer rounds;
    private final List<Car> cars;

    public Race(final Integer rounds, final List<Car> cars) {
        this.rounds = rounds;
        this.cars = cars;
    }
}
