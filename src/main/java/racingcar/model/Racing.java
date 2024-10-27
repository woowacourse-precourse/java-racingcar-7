package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> carList;

    public Racing(String cars) {
        carList = Arrays.stream(cars.split(","))
                .map(Car::new)
                .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void runRound() {
        carList.forEach(Car::move);
    }

    public int calcMaxDistance() {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }

    public List<Car> getWinner() {
        return carList.stream()
                .filter(c -> c.getDistance() == calcMaxDistance())
                .toList();
    }

    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
