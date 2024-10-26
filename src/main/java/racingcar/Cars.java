package racingcar;

import java.util.List;
import racingcar.Car.Car;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars;
    }

}
