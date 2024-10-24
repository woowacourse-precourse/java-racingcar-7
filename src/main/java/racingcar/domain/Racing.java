package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.MoveRule;

public class Racing {
    private final List<Car> cars;

    private Racing(final List<Car> cars) {
        this.cars = cars;
    }

    public static Racing create(final List<Car> cars) {
        return new Racing(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void performRace(final MoveRule moveRule) {
        for (Car car : cars) {
            car.move(moveRule.tryMove());
        }
    }

    public List<String> findWinners() {
        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
    
}
