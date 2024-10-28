package racingcar.domain.race.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;

public class RaceHelper {

    private final String WINNER_DELIMITER = ", ";

    public List<Car> determineWinners(Race race) {
        List<Car> cars = race.getCars();
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
            .filter(car -> car.isAtPosition(maxPosition))
            .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalArgumentException::new);
    }

    public String findWinners(Race race) {
        return determineWinners(race).stream()
            .map(Car::getName)
            .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
