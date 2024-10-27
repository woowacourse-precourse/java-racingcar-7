package racingcar.racing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {

    Set<Car> cars = new HashSet<>();

    public Racing(List<String> cars) {
        this.cars.addAll(Car.to(cars));
    }

    public List<String> race() {
        return cars.stream().map(car -> {
            car.moveCar();
            return car.toString();
        }).toList();
    }

    public List<String> getWinners() {
        int max = findMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == max)
                .map(Car::getName)
                .toList();
    }

    private int findMaxDistance() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }
}
