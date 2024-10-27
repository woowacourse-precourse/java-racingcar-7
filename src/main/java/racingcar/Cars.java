package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final String input) {
        this.cars = Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
