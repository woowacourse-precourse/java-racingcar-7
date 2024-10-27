package racingcar.model.winner;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private int max = Integer.MIN_VALUE;
    private final Cars cars;

    public Winners(Cars cars) {
        this.cars = cars;
    }

    public List<String> getRacingGameWinners() {
        max();
        return cars.getCars().stream()
                .filter(this::isValid)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private boolean isValid(Car car) {
        return car.getMoveNumber() == max;
    }

    private void max() {
        cars.getCars().stream()
                .map(Car::getMoveNumber)
                .forEach(moveNumber -> max = Math.max(max, moveNumber));
    }


}
