package racingcar.domain;

import java.util.List;

public class CarRace {

    List<Car> cars;

    public CarRace(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
