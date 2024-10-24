package racingcar.model;

import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars of(List<String> names) {
        cars = names.stream().map(Car::of).toList();
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
