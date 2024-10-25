package racingcar.model.car;

import java.util.List;
import java.util.Objects;
import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.model.position.Distance;

public class Cars {
    private final List<Car> cars;

    public static Cars of(final List<Car> cars) {
        return new Cars(cars);
    }

    private Cars(final List<Car> cars) {
        validateIsNotNull(cars);
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            Distance distance = car.movableDistance();
            if (distance.isBiggerThanZero()) {
                car.updateProgress(distance);
            }
        }
    }

    public List<String> currentPositions() {
        return cars.stream()
                .map(Car::myProgressSummary)
                .toList();
    }

    public List<Car> filterCompletedAllLap() {
        return cars.stream()
                .filter(Car::completedAllLap)
                .toList();
    }


    private void validateIsNotNull(final List<Car> cars) {
        boolean matched = cars.stream().anyMatch(Objects::isNull);
        if (matched) {
            throw new ShouldNotBeNullException();
        }
    }
}
