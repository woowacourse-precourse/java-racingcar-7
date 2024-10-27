package racingcar.Domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    private List<Car> getCars() {
        return cars;
    }

}
