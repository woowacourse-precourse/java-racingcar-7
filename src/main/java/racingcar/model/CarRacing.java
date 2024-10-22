package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private final List<Car> carList = new ArrayList<>();

    public void enroll(String name) {
        carList.add(Car.of(name));
    }
}
