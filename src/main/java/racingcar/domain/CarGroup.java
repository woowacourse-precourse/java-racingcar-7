package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {

    List<Car> cars;

    private CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static CarGroup of(List<Car> cars) {
        return new CarGroup(cars);
    }

    public void race() {
        cars.forEach(Car::moveForward);
    }

    public List<String> getStatus() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public List<Car> getFarthestCars() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }
}
