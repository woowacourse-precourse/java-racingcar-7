package racingcar.domain;

import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Race race)) {
            return false;
        }
        return (Objects.equals(carList, race.carList) && (Objects.equals(attemptCount, race.attemptCount)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList, attemptCount);
    }
}
