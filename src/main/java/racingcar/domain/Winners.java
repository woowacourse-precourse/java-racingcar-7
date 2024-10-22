package racingcar.domain;

import static racingcar.domain.Car.DEFAULT_POSITION;

import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(Cars cars) {
        this.winners = determineWinners(cars.getCars());
    }

    private List<Car> determineWinners(List<Car> cars) {
        return cars.stream()
                .filter(car -> car.isWin(calculateWinnerPosition(cars)))
                .toList();
    }

    private int calculateWinnerPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION);
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
