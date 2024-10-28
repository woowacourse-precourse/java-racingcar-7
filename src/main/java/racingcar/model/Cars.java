package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        return new Cars(names.stream().map(Car::of).toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        Optional<Integer> optionalInteger = cars.stream().map(Car::getLocation).reduce(Integer::max);
        int maxNumber = optionalInteger.get();
        return cars.stream().filter(car -> car.getLocation() == maxNumber).toList();
    }

    public void startRace() {
        cars.forEach(Car::startRace);
    }
}
