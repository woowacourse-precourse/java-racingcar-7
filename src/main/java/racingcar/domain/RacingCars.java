package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name, 0));
        }
    }
}
