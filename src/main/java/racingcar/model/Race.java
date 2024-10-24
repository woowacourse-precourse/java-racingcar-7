package racingcar.model;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class Race {

    private final List<Car> winners;

    public Race(Cars cars, AttemptCount attemptCount) {
        winners = start(cars, attemptCount);
    }

    private List<Car> start(Cars cars, AttemptCount attemptCount) {
        int count = attemptCount.getAttemptCount();
        IntStream.range(0, count).forEach(i -> moveCars(cars));
        return findWinners(cars);
    }

    private void moveCars(Cars cars) {
        cars.getCars().forEach(car -> moveCar(car, RandomNumberGenerator.generateNumber()));
    }

    private void moveCar(Car car, int number) {
        car.move(number);
    }

    private List<Car> findWinners(Cars cars) {
        return cars.getCars().stream()
                .filter(car -> car.getLocation() == findWinnerLocation(cars))
                .toList();
    }

    private int findWinnerLocation(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }
}
