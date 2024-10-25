package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void saveCar(final Car car) {
        cars.add(car);
    }
}
