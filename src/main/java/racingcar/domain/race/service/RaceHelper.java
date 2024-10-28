package racingcar.domain.race.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;
import racingcar.domain.race.vo.Winners;

public class RaceHelper {

    private final String WINNER_DELIMITER = ", ";

    public Winners findWinners(Race race) {
        return new Winners(determineWinners(race));
    }

    public List<String> determineWinners(Race race) {
        List<Car> cars = race.getCars();
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
            .filter(car -> car.isAtPosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalArgumentException::new);
    }
}
