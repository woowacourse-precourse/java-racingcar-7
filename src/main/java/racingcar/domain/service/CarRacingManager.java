package racingcar.domain.service;

import racingcar.domain.model.car.Car;
import racingcar.domain.model.constant.CarConstants;
import racingcar.domain.util.CarNameParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRacingManager {
    private final Map<String, Car> cars = new HashMap<>();

    private CarRacingManager(List<Car> carList) {
        carList.forEach(car -> {
            cars.put(car.getName(), car);
        });
    }

    public static CarRacingManager from(final String input) {
        List<String> parsed = CarNameParser.parse(input);
        List<Car> carList = parsed.stream()
                .map(Car::from)
                .toList();
        return new CarRacingManager(carList);
    }

    public List<String> getNames() {
        return cars.keySet().stream().toList();
    }

    public List<Car> getList() {
        return List.copyOf(cars.values());
    }

    public int getDistance(final String name) {
        return cars.get(name).getDistance();
    }

    public void moveForward(final String name) {
        cars.get(name).moveForward();
    }

    public String getWinners() {
        return getFirstPrizeCarList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(CarConstants.JOIN_DELIMITER));
    }

    private List<Car> getFirstPrizeCarList() {
        List<Car> ranked = getRankedCarList();
        final int maxDistance = ranked.getFirst().getDistance();
        return ranked.stream()
                .filter(c->c.getDistance() == maxDistance)
                .toList();
    }

    private List<Car> getRankedCarList() {
        return cars.values().stream()
                .sorted((a, b) -> b.getDistance() - a.getDistance())
                .toList();
    }
}
