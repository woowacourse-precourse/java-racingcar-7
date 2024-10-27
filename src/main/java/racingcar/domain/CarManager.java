package racingcar.domain;

import java.util.List;

public class CarManager {
    private List<Car> cars;

    public CarManager(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}