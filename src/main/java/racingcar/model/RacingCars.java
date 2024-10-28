package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> racingCars = new ArrayList<>();

    public void add(Car car) {
        racingCars.add(car);
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public List<String> getRaceWinner() {

        int maxDistance = findMaxDistance();

        return racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private int findMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
