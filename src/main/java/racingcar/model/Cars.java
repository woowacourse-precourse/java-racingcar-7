package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public List<Car> getWinners() {
        Optional<Integer> optionalInteger = cars.stream().map(Car::getLocation).reduce(Integer::max);
        int maxNumber = optionalInteger.get();
        return cars.stream().filter(car -> car.getLocation() == maxNumber).toList();
    }
}
