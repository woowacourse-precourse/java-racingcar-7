package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
