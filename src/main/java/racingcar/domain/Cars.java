package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveAll() {
        this.cars.forEach(Car::move);
    }

    public List<Car> getWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElseThrow(IllegalArgumentException::new);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
