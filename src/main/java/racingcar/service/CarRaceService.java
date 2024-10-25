package racingcar.service;

import static java.util.stream.Collectors.toMap;
import static racingcar.enums.ExceptionMessage.CAR_NOT_FOUND;
import static racingcar.util.RandomUtil.getRandomNumberInRange;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class CarRaceService {

    private List<Car> cars;

    public void init(String carNames) {
        this.cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> canMove())
                .forEach(Car::move);
    }

    public Map<String, String> getCarsStatus() {
        return cars.stream()
                .collect(toMap(
                        Car::getName,
                        Car::getMovingDistance
                ));
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getMovingDistance().length() == getMaxDistance())
                .map(Car::getName)
                .toList();
    }

    private boolean canMove() {
        return getRandomNumberInRange(0, 9) >= 4;
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(car -> car.getMovingDistance().length())
                .max()
                .orElseThrow(() -> new IllegalArgumentException(CAR_NOT_FOUND.getMessage()));
    }
}
