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

    public List<Car> getCars() {
        return cars;
    }
}
