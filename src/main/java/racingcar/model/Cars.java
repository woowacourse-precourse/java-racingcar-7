package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }
}
