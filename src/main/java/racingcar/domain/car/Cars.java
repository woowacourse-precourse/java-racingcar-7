package racingcar.domain.car;

import java.util.List;
import java.util.ArrayList;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }
}