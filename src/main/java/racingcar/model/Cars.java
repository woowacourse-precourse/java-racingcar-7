package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    protected Cars() {
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public static Cars newCars() {
        return new Cars();
    }
}
