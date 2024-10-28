package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceService {

    private final Cars cars;
    private final int round;

    public RaceService(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Car> getWinners() {
        return cars.getWinnerNames();
    }

    public List<Map<Car, Integer>> createRaceLogs() {
        List<Map<Car, Integer>> raceResults = IntStream.range(0, round)
                .mapToObj(i -> Collections.unmodifiableMap(createRaceResult()))
                .toList();

        return raceResults;
    }

    private Map<Car, Integer> createRaceResult() {
        cars.move();

        Map<Car, Integer> raceResult = cars.getCars().stream()
                .collect(Collectors.toMap(
                        car -> car,
                        car -> car.getPosition(),
                        (car1, car2) -> car1,
                        LinkedHashMap::new
                ));

        return raceResult;
    }
}
