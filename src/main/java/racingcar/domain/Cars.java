package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class Cars {
    private static Cars instance;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars getInstance(List<Car> cars) {
        if (instance == null) {
            instance = new Cars(cars);
        }
        return instance;
    }

    public void moveCars(RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.move(randomNumberGenerator.move()));
    }

    public Map<String, Integer> getResult() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public Set<String> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toSet());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
