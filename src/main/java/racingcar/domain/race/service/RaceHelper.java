package racingcar.domain.race.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;

public class RaceHelper {

    public List<Car> findWinners(Race race) {
        List<Car> cars = race.getCars();

        int maxPosition = cars.stream()
            .mapToInt(car -> car.getPosition())
            .max()
            .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }
}
