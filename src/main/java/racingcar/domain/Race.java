package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> carList;
    private final int attemptCount;

    public Race(final List<Car> carList, final int attemptCount) {
        this.carList = carList;
        this.attemptCount = attemptCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public List<Integer> getDistanceList() {
        return getCarList().stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
    }
}
