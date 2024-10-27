package repository;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import model.Car;

public class CarRepository {
    private static final List<Car> cars = new ArrayList<>();

    public static List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static void addCars(List<Car> newCars) {
        cars.clear();
        cars.addAll(newCars);
    }
}
