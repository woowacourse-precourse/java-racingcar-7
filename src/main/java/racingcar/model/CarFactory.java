package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private List<Car> cars;

    public List<Car> produceCars(final List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
