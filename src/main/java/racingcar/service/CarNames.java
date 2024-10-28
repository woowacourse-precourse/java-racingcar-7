package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.Entity.Car;

public class CarNames {
    private final List<Car> cars = new ArrayList<>();

    public CarNames(String names) {
        String[] splitNames = names.split(",");
        for (String name : splitNames) {
            cars.add(new Car(name.trim()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
