package racingcar.model;

import java.util.List;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getNamesOfWinner() {
        return cars.stream().map(Car::getName).toList();
    }
}
