package racingcar.model.game;

import java.util.List;
import racingcar.model.car.Car;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getNamesOfWinner() {
        return cars.stream().map(Car::getName).toList();
    }
}
